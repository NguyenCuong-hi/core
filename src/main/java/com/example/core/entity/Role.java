package com.example.core.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "role")
public class Role extends BaseObject implements GrantedAuthority {

    @Transient
    private static final long serialVersionUID = 1L;

    @Column(name = "role_name", length = 255, nullable =true)
    private String name;

    @Column(name = "role_description", length = 255, nullable =true)
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

    @Override
    public String getAuthority() {
        return this.name;
    }


}
