package com.example.core.service;

import com.example.core.dto.request.AuthenticationReqDto;
import com.example.core.dto.response.AuthenticationRespDto;
import com.example.core.dto.response.IntroSpecRespDto;
import com.nimbusds.jose.JOSEException;

import java.text.ParseException;

public interface AuthenticationService {

    IntroSpecRespDto introspect (String token);

    AuthenticationRespDto authenticate (AuthenticationReqDto request);

    void  logout(String token);

    AuthenticationRespDto refreshToken (String token) throws ParseException, JOSEException;


}
