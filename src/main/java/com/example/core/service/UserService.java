package com.example.core.service;

import com.example.core.dto.request.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    Page<UserDto> searchUser();

    UserDto getUserById(Long id);

    UserDto getUserByUsername(String username);

    UserDto createBy(UserDto user);

    UserDto updateBy(Long id, UserDto userDto);

    Boolean deleteBy(Long id);
}
