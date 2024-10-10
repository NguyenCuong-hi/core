package com.example.core.dto.request;

import com.example.core.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class UserDto extends AuditableEntityDto {

    private Long id;

    private String username;

    private String password;

    private String email;

    private String phoneNumber;

    private Set<RoleDto> roles;

    private Set<UserGroupDto> userGroups;

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

    public UserDto(){

    }

    public UserDto(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();

    }

    public User toEntity() {
        User entity = new User();
        entity.setId(this.id);
        entity.setUsername(this.username);
        entity.setPassword(this.password);
        entity.setEmail(this.email);
        entity.setPhoneNumber(this.phoneNumber);
        entity.setAccountNonExpired(true);
        entity.setAccountNonLocked(true);
        entity.setCredentialsNonExpired(true);

        Iterator iRole;
        if (this.roles.size() > 0){
            iRole = this.roles.iterator();
            while (iRole.hasNext()){
                RoleDto roleDto = (RoleDto) iRole.next();
                entity.getRoles().add(roleDto.toEntity());
            }
        }

        Iterator iUserGroup;
        if (this.userGroups.size()> 0){
            iUserGroup = this.userGroups.iterator();
            while (iUserGroup.hasNext()){
                UserGroupDto userGroupDto = (UserGroupDto) iUserGroup.next();
                entity.getUserGroups().add(userGroupDto.toEntity());
            }
        }
        return entity;
    }



}
