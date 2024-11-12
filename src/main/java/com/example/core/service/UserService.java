package com.example.core.service;

import com.example.core.dto.request.PersonDto;
import com.example.core.dto.request.UserDto;
import com.example.core.dto.request.search.SearchDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    Page<UserDto> searchUser(SearchDto searchDto);

    UserDto getUserById(Long id);

    UserDto getUserByUsername(String username);

    UserDto createBy(UserDto user);

    UserDto createBy(PersonDto personDto);

    UserDto updateBy(Long id, UserDto userDto);

    Boolean deleteBy(Long id);
}
