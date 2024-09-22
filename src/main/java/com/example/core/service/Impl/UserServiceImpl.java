package com.example.core.service.Impl;

import com.example.core.dto.request.UserDto;
import com.example.core.entity.User;
import com.example.core.repository.UserRepository;
import com.example.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Override
    public Page<UserDto> searchUser() {

        List<User> users = userRepository.getAllBy();
        users.
        return null;
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.getById(id);
        return new UserDto(user);
    }

    public UserDto createBy (UserDto userDto){
        User user = new User();
        this.validUserDto(userDto);
        this.setUser(userDto, user);
        return new UserDto(user);
    }

    public UserDto updateBy (Long id, UserDto userDto){
        User user = userRepository.getById(id);
        this.validUserDto(userDto);
        this.validBeforeUpdate(user);
        this.setUser(userDto, user);
        return new UserDto(user);
    }

    private void validUserDto(UserDto userDto){

    }

    private void validBeforeUpdate(User user){

    }

    private void setUser(UserDto userDto, User user){
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setRoles(userDto.getRoles());
        user.setUserGroups(userDto.getUserGroups());
        user.setLastLogin(userDto.getLastLogin());
        user.setDescription(user.getDescription());
        user.setNote(user.getNote());
    }


    private void validateBeforeDelete(User user){

    }
    public Boolean deleteBy(Long id){
        User user = userRepository.getById(id);
        this.validateBeforeDelete(user);
        userRepository.delete(user);
        return true;
    }

}
