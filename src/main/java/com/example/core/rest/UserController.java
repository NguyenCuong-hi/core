package com.example.core.rest;

import com.example.core.dto.request.UserDto;
import com.example.core.dto.request.search.SearchDto;
import com.example.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/page")
//    @PreAuthorize("hasAuthority('" + ADMIN_VIEW + "')")
    public Page<UserDto> getPage(@RequestBody SearchDto searchDto) {
        return userService.searchUser(searchDto);
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable(value = "id") Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/username")
    public UserDto getByUserName(@RequestParam(value = "username") String userName,
                                 @RequestParam(value = "token") String token) {
        return userService.getUserByUsername(userName, token);
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
