package com.example.core.service;

import com.example.core.dto.request.AuthenticationReqDto;
import com.example.core.dto.request.OTPRequestDto;
import com.example.core.dto.response.AuthenticationRespDto;
import com.example.core.dto.response.IntroSpecRespDto;
import com.example.core.dto.response.OTPResponseDto;
import com.nimbusds.jose.JOSEException;

import java.text.ParseException;

public interface AuthenticationService {

    IntroSpecRespDto introspect (String token);

    AuthenticationRespDto authenticate (AuthenticationReqDto request);

    OTPResponseDto getOTP (String request);

    AuthenticationRespDto authOTP (OTPRequestDto request);

    void  logout(String token);

    AuthenticationRespDto refreshToken (String token) throws ParseException, JOSEException;


}
