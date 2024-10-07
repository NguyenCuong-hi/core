package com.example.core.service.Impl;

import com.example.core.dto.request.RoleDto;
import com.example.core.dto.request.UserDto;
import com.example.core.dto.request.UserGroupDto;
import com.example.core.entity.Role;
import com.example.core.entity.User;
import com.example.core.entity.UserGroup;
import com.example.core.repository.RoleRepository;
import com.example.core.repository.UserRepository;
import com.example.core.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepo;

    @Override
    public Page<UserDto> searchUser() {

        List<User> users = userRepo.getAllBy();
        return null;
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepo.getById(id);
        return new UserDto(user);
    }

    @Override
    public UserDto getUserByUsername(String username) {
        User user = userRepo.getUserByUsername(username);
        return new UserDto(user);
    }

    @Override
    public UserDto createBy(UserDto userDto) {
        User user = new User();
        this.validUserDto(userDto);
        this.setUser(userDto, user);
        userRepo.save(user);
        return new UserDto(user);
    }

    public UserDto updateBy(Long id, UserDto userDto) {
        User user = userRepo.getById(id);
        this.validUserDto(userDto);
        this.validBeforeUpdate(user);
        this.setUser(userDto, user);
        return new UserDto(user);
    }

    private void validUserDto(UserDto userDto) {

    }

    private void validBeforeUpdate(User user) {

    }

    private void setUser(UserDto userDto, User user) {
        Set<Role> roleSet = new HashSet<>();
        Set<UserGroup> userGroups = new HashSet<>();
        this.setListRoles(userDto.getRoles(), roleSet);
        this.validRoles(roleSet);
        this.setUserGroup(userDto.getUserGroups(), userGroups);

        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setRoles(roleSet);
        user.setUserGroups(userGroups);
        user.setLastLogin(userDto.getLastLogin());
        user.setDescription(user.getDescription());
        user.setNote(user.getNote());
    }

    private void validRoles(Set<Role> roles) {
//        if (!roleRepo.isExitsBy(roles)) {
//
//        }
    }

    private void setListRoles(Set<RoleDto> dtoSet, Set<Role> entities) {
        for (RoleDto dto : dtoSet) {
            entities.add(dto.toEntity());
        }
    }

    private void setUserGroup(Set<UserGroupDto> userGroups, Set<UserGroup> entities){
        for (UserGroupDto dto : userGroups) {
            entities.add(dto.toEntity());
        }
    }

    private void validateBeforeDelete(User user) {

    }

    public Boolean deleteBy(Long id) {
        User user = userRepo.getById(id);
        this.validateBeforeDelete(user);
        userRepo.delete(user);
        return true;
    }

}
