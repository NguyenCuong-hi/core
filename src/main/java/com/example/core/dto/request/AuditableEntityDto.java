package com.example.core.dto.request;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AuditableEntityDto implements Serializable {

    public static final Long serialVersionUID = 1L;

    protected LocalDateTime createdDate;

    protected String createBy;

    protected LocalDateTime modifyDate;

    protected String modifyBy;

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public AuditableEntityDto() {
    }

    public AuditableEntityDto(AuditableEntityDto auditableEntityDto) {
        this.createdDate = auditableEntityDto.createdDate;
        this.createBy = auditableEntityDto.createBy;
        this.modifyDate = auditableEntityDto.modifyDate;
        this.modifyBy = auditableEntityDto.modifyBy;
    }
}
