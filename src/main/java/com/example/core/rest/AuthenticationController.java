package com.example.core.rest;

import com.example.core.dto.request.AuthenticationReqDto;
import com.example.core.dto.request.OTPRequestDto;
import com.example.core.dto.response.AuthenticationRespDto;
import com.example.core.dto.response.IntroSpecRespDto;
import com.example.core.dto.response.OTPResponseDto;
import com.example.core.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authService;

    @PostMapping("/token")
    AuthenticationRespDto auth (@RequestBody AuthenticationReqDto dto){
        return authService.authenticate(dto);
    }

    @PostMapping("/introspect")
    IntroSpecRespDto auth (@RequestParam (value = "token") String token){
        return authService.introspect(token);
    }

    @PostMapping("/otp")
    OTPResponseDto otp (@RequestParam String phoneNumber){
        return authService.getOTP(phoneNumber);
    }

    @PostMapping("/verified-otp")
    AuthenticationRespDto verified (@RequestBody OTPRequestDto dto){
        return authService.authOTP(dto);
    }
}
