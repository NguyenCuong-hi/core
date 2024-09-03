package com.example.core.dto.request;

import com.example.core.entity.BaseObject;

import java.util.UUID;

public class BaseObjectDto extends AuditableEntityDto {

    public static final Long serialVersionUID = 1L;

    private Long id;

    private UUID uuid;

    private Boolean voided;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Boolean getVoided() {
        return voided;
    }

    public void setVoided(Boolean voided) {
        this.voided = voided;
    }

    public BaseObjectDto() {
    }

    public BaseObjectDto(AuditableEntityDto auditableEntityDto) {
        super(auditableEntityDto);
    }

    public BaseObjectDto(BaseObject entity) {
        if (entity != null) {
            this.id = entity.getId();
            if (entity.getVoided() != null) {
                this.voided = entity.getVoided();
            }
        }
    }
}
