package com.example.core.rest;

import com.example.core.dto.request.UserDto;
import com.example.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable(value = "id") Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public UserDto createBy(@RequestBody UserDto userDto) {
        return userService.createBy(userDto);
    }

    @PutMapping("/{id}")
    public UserDto updateBy(@PathVariable(value = "id") Long id,
                            @RequestBody UserDto userDto) {
        return userService.updateBy(id, userDto);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteBy(@PathVariable(value = "id") Long id) {
        return userService.deleteBy(id);
    }


}
