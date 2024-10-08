package com.example.core.dto.request;

import lombok.Builder;

@Builder
public class IntroSpecReqDto {

    private String token;

    public IntroSpecReqDto() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public IntroSpecReqDto(String token) {
        this.token = token;
    }
}
