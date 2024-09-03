package com.example.core.dto.request;

import com.example.core.entity.BaseObject;
import com.example.core.entity.Role;
import com.example.core.entity.User;
import com.example.core.entity.UserGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class UserDto extends BaseObject {

    private String username;

    private String password;

    private String email;

    private Set<Role> roles;

    private Set<UserGroup> userGroups;

    private Boolean justCreated;

    private Date lastLogin;

    private Long totalLoginFailures;

    private Long lastLoginFailures;

    private Boolean changePassword;

    private String confirmPassword;

    private Boolean isActive;

    private Boolean isAccountNonExpired;

    private Boolean isAccountNonLocked;

    private Boolean isCredentialsNonExpired;

    private String description;

    private String note;

    public UserDto(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();

        this.roles = user.getRoles();
        this.userGroups = user.getUserGroups();
    }


}
