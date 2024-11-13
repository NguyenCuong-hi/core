package com.example.core.service;

import com.example.core.dto.request.RoleDto;
import com.example.core.dto.request.UserDto;
import com.example.core.dto.request.UserGroupDto;
import com.example.core.entity.User;
import com.example.core.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {

     @MockBean
     private UserService userService;

    @MockBean
    private UserRepository userRepo;

     private UserDto userDto = new UserDto();

     private User user;

    @BeforeEach
    void initData(){

        userDto.setUsername("admin");
        userDto.setPassword("admin");
        userDto.setEmail("admin@gmail.com");

        RoleDto role = new RoleDto();
        role.setId(1L);
        role.setName("ADMIN");
        role.setDescription("Role Admin");

        Set<RoleDto> roles = new HashSet<>();
        roles.add(role);
        userDto.setRoles(roles);

        UserGroupDto userGroupDto = new UserGroupDto();
        userGroupDto.setId(1L);
        userGroupDto.setName("ADMIN");
        userGroupDto.setDescription("GROUP_ADMIN");

        Set<UserGroupDto> userGroupDtos = new HashSet<>();
        userGroupDtos.add(userGroupDto);

        userDto.setUserGroups(userGroupDtos);

        userDto.setJustCreated(true);

    }

    @Test
    void createUserValidRequestSuccess(){
        when(userRepo.existsById(anyLong())).thenReturn(false);
//        when(userService.createBy(any())).thenReturn(userDto);

        var response = userService.createBy(userDto);

        Assertions.assertThat(response).isEqualTo(userDto);

    }


}
