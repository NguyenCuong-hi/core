package com.example.core.rest;

import com.example.core.dto.request.AuthenticationReqDto;
import com.example.core.dto.response.AuthenticationRespDto;
import com.example.core.dto.response.IntroSpecRespDto;
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

    @PostMapping("/introspec")
    IntroSpecRespDto auth (@RequestParam (value = "token") String token){
        return authService.introspect(token);
    }
}
