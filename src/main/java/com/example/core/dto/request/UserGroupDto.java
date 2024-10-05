package com.example.core.dto.request;


import com.example.core.entity.UserGroup;

import java.io.Serializable;

public class UserGroupDto implements Serializable {

    private Long id;

    private String name;

    private String description;

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

    public UserGroup toEntity(){
        UserGroup entity = new UserGroup();
        entity.setId(this.getId());
        entity.setName(this.getName());
        entity.setDescription(this.getDescription());
        return entity;
    }

    public UserGroupDto (UserGroup entity){
        this.setId(entity.getId());
        this.setName(entity.getName());
        this.setDescription(entity.getDescription());
    }

    public UserGroupDto(){

    }
}
