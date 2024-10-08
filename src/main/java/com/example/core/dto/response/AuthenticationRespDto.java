package com.example.core.dto.response;

import lombok.Builder;

@Builder
public class AuthenticationRespDto {

    private String token;
    private Boolean authenticated;

    public AuthenticationRespDto() {
    }

    public AuthenticationRespDto(String token, Boolean authenticated) {
        this.token = token;
        this.authenticated = authenticated;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
    }
}
