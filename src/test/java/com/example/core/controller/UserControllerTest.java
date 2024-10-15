package com.example.core.controller;

import com.example.core.dto.request.UserDto;
import com.example.core.entity.User;
import com.example.core.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc

public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private UserDto userDto;

    private User user;

    @BeforeEach
    void init(){

        UserDto request = new UserDto();
        request.setUsername("test");
        request.setPassword("test");
        request.setEmail("admin@gmail.com");


    }

    @Test
    void getUserValidSuccess(){

        var response = userService.getUserById(new Long(5));
        Assertions.assertThat(response.getUsername()).isEqualTo("admin");

    }

    @Test
    void createUserValidSuccess(){

    }

    @Test
    void updateUserValidSuccess(){

    }

    @Test
    void deleteUserValidSuccess(){

    }

}
