package com.example.core.dto.response;

import lombok.Builder;

@Builder
public class IntroSpecRespDto {
    private Boolean valid;

    public IntroSpecRespDto() {
    }

    public IntroSpecRespDto(Boolean valid) {
        this.valid = valid;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}
