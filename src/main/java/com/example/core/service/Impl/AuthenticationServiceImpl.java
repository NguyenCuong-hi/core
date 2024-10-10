package com.example.core.service.Impl;

import com.example.core.configuration.UserDetailService;
import com.example.core.dto.request.AuthenticationReqDto;
import com.example.core.dto.request.OTPRequestDto;
import com.example.core.dto.response.AuthenticationRespDto;
import com.example.core.dto.response.IntroSpecRespDto;
import com.example.core.dto.response.OTPResponseDto;
import com.example.core.entity.Token;
import com.example.core.entity.User;
import com.example.core.repository.AuthenticationRepository;
import com.example.core.repository.UserRepository;
import com.example.core.service.AuthenticationService;
import com.example.core.service.OTPService;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.persistence.EntityNotFoundException;
import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {


    @Value("${security.jwt.signal-key}")
    private String SIGNER_KEY;

    @Value("${security.jwt.time-refresh}")
    private Long REFRESH_TOKEN_TIME;

    private final AuthenticationRepository authRepo;

    private final UserRepository userRepo;

    private final OTPService otpService;

    @Override
    public IntroSpecRespDto introspect(String token) {
        boolean isValid = true;
        try{
            verifyToken(token, false);
        } catch (Exception e){
            isValid = false;
        }
        return IntroSpecRespDto.builder().valid(isValid).build();
    }

    private SignedJWT verifyToken (String token, boolean isRefresh) throws JOSEException, ParseException {
        JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());
        SignedJWT signedJWT = SignedJWT.parse(token);

        Date expiredTime = (isRefresh) ?
                new Date(
                        signedJWT.getJWTClaimsSet()
                                .getIssueTime()
                                .toInstant().plus(REFRESH_TOKEN_TIME, ChronoUnit.SECONDS).toEpochMilli())
                : signedJWT.getJWTClaimsSet().getExpirationTime();

        boolean verified = signedJWT.verify(verifier);

        if (!verified && expiredTime.after(new Date()))
            throw new VerifyError("");
        if (authRepo.existsById(UUID.fromString(signedJWT.getJWTClaimsSet().getJWTID())))
            throw new VerifyError("");

        return signedJWT;
    }

    @Override
    public AuthenticationRespDto authenticate(AuthenticationReqDto request) {

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        var user = userRepo.getUserByUsername(request.getUsername());
        if (ObjectUtils.isEmpty(user))
            throw new EntityNotFoundException();
        boolean authenticated = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if (!authenticated)
            throw new EntityNotFoundException();

        var token = generationToken(user);

        return AuthenticationRespDto.builder().token(token).authenticated(true).build();
    }

    @Override
    public OTPResponseDto getOTP(String phoneNumber) {
        OTPResponseDto response = new OTPResponseDto();
        try{
            String otp = otpService.generateOTP(phoneNumber);
            response.setOtp(otp);
            response.setStatus(true);
            response.setMessage("Successful");
        }
        catch (Exception e){
            response.setStatus(false);
            response.setMessage("Fail");
        }
        return response;
    }

    @Override
    public AuthenticationRespDto authOTP(OTPRequestDto request) {
        String token = null;
        try {
            if (request.getOtp().equals(otpService.getCacheOTP(request.getOtp()))){
                User user = new User();
                user.setUsername(request.getPhoneNumber());
                token = generationToken(user);

                otpService.clearOTP(request.getOtp());
            }
        }
        catch (Exception e){

        }
        return AuthenticationRespDto.builder().token(token).build();
    }

//    private String checkAuthToken(OTPRequestDto otp) throws Exception {
//        try{
//            authManager.authenticate( new UsernamePasswordAuthenticationToken(otp.getPhoneNumber(), ""));
//        }
//        catch (BadCredentialsException e){
//            throw new Exception("I", e);
//        }
//
//
//    }


    private String generationToken(User user){
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(user.getUsername())
                .issuer("random")
                .issueTime(new Date(Instant.now().plus(3600, ChronoUnit.SECONDS).toEpochMilli()))
                .jwtID(UUID.randomUUID().toString())
                .claim("scope", buildScope(user) )
                .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());
        JWSObject jwsObject = new JWSObject(header, payload);
        try {
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));

            Token token = new Token();
            token.setId(UUID.fromString(jwtClaimsSet.getJWTID()));
            token.setExpiredTime(null);
            authRepo.save(token);
            return jwsObject.serialize();
        } catch (JOSEException e) {
            log.info("Cannot create token", e);
            throw new RuntimeException();
        }

    }

    private String buildScope(User user){
        StringBuilder str = new StringBuilder("");

        if (!CollectionUtils.isEmpty(user.getRoles())){
            user.getRoles().forEach(role -> {
                str.append("ROLE_").append(role.getName());

            });
        }
        return str.toString();
    }

    @Override
    public void logout(String token) {

    }

    @Override
    public AuthenticationRespDto refreshToken(String token) throws ParseException, JOSEException {
        var signedJWT = verifyToken(token, true);

        return null;
    }
}
