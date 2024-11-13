package com.example.core.dto.request;

import com.example.core.dto.response.MenuGroupResDto;
import com.example.core.entity.MenuAction;
import com.example.core.entity.MenuGroup;
import com.example.core.entity.Role;
import liquibase.pro.packaged.M;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class RoleDto extends AuditableEntityDto {
    private static final long serialVersionUID = 1L;
    private Long id;

    private String name;

    private String description;

    private Set<MenuGroupResDto>  menuGroups;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public RoleDto(Role entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        if (!CollectionUtils.isEmpty(entity.getMenuGroups())){
            Set<MenuGroupResDto> menuGroups = new HashSet<>();
            for (MenuGroup menuGroup : entity.getMenuGroups()){
                MenuGroupResDto res = new MenuGroupResDto(menuGroup);
                menuGroups.add(res);
            }
            this.menuGroups = menuGroups;
        }
    }

    public Role toEntity() {
        Role entity = new Role();
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setDescription(this.description);
        return entity;
    }
}
