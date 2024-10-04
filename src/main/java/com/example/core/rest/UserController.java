package com.example.core.rest;

import com.example.core.dto.request.UserDto;
import com.example.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/page")
    public Page<UserDto> getPage() {
        return userService.searchUser();
    }

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
