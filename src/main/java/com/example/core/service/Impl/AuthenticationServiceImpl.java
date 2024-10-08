package com.example.core.service.Impl;

import com.example.core.dto.request.AuthenticationReqDto;
import com.example.core.dto.response.AuthenticationRespDto;
import com.example.core.dto.response.IntroSpecRespDto;
import com.example.core.entity.User;
import com.example.core.repository.AuthenticationRepository;
import com.example.core.repository.UserRepository;
import com.example.core.service.AuthenticationService;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimNames;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.naming.AuthenticationException;
import javax.persistence.EntityNotFoundException;
import java.text.ParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {


    private final String SIGNER_KEY;
    private final Long REFRESH_TOKEN_TIME;
    private final AuthenticationRepository authenRepo;
    private final UserRepository userRepo;

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
        if (authenRepo.existsById(UUID.fromString(signedJWT.getJWTClaimsSet().getJWTID())))
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

    private String generationToken(User user){
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(user.getUsername())
                .issuer("random")
                .issueTime(new Date())
                .build();
    }

    @Override
    public void logout(String token) {

    }

    @Override
    public AuthenticationRespDto refreshToken(String token) {
        return null;
    }
}
