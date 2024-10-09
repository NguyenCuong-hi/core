package com.example.core.service;

import com.example.core.dto.request.UserDto;
import com.example.core.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class UserServiceTest {

     @MockBean
     private UserService userService;

     private UserDto userDto;

     private User user;

    @BeforeEach
    void initData(){

    }

    @Test
    void createUserValidRequestSuccess(){

    }
}
