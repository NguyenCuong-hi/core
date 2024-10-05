package com.example.core.rest;

import com.example.core.dto.request.UserGroupDto;
import com.example.core.service.UserGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user-group")
@RequiredArgsConstructor
public class UserGroupController {

    private final UserGroupService userGrService;

    @GetMapping("/{id}")
    public UserGroupDto getById(@PathVariable(value = "id") Long id) {
        return userGrService.getUserGroup(id);
    }

    @PostMapping
    public UserGroupDto createBy(@RequestBody UserGroupDto userGroupDto) {
        return userGrService.createBy(userGroupDto);
    }

    @PutMapping("/{id}")
    public UserGroupDto updateBy(@PathVariable(value = "id") Long id,
                                 @RequestBody UserGroupDto roleDto) {
        return userGrService.updateBy(id, roleDto);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteBy(@PathVariable(value = "id") Long id) {
        return userGrService.deleteBy(id);
    }
}
