package com.example.core.dto.request;

import com.example.core.entity.BaseObject;
import com.example.core.entity.Role;

public class RoleDto extends BaseObjectDto {

    private String name;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RoleDto() {

    }

    public RoleDto(AuditableEntityDto auditableEntityDto, String name) {
        super(auditableEntityDto);
        this.name = name;
    }

    public RoleDto(BaseObject entity, String name) {
        super(entity);
        this.name = name;
    }

    public RoleDto(Role role) {
        this.name = role.getName();
        this.description = role.getDescription();
    }
}
