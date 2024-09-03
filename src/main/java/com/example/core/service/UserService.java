package com.example.core.service;

import com.example.core.dto.request.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserDto getUserById(Long id);

    UserDto createBy(UserDto user);

    UserDto updateBy(Long id, UserDto userDto);

    Boolean deleteBy(Long id);
}
