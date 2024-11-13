package com.example.core.rest;

import com.example.core.dto.request.MenuGroupReqDto;
import com.example.core.dto.request.RoleDto;
import com.example.core.dto.request.search.SearchDto;
import com.example.core.dto.response.MenuGroupResDto;
import com.example.core.service.MenuGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/menu-groups")
@RequiredArgsConstructor
public class MenuGroupController {

    private final MenuGroupService menuGroupService;

    @GetMapping("/{id}")
    public MenuGroupResDto getById(@PathVariable(value = "id") Long id) {
        return menuGroupService.getMenuGroup(id);
    }

    @GetMapping("/page")
    public Page<MenuGroupResDto> searchBy(@RequestBody SearchDto searchDto) {
        return menuGroupService.searchBy(searchDto);
    }

    @PostMapping
    public MenuGroupResDto createBy(@RequestBody MenuGroupReqDto roleDto) {
        return roleService.createBy(roleDto);
    }

    @PutMapping("/{id}")
    public RoleDto updateBy(@PathVariable(value = "id") Long id,
                            @RequestBody RoleDto roleDto) {
        return roleService.updateBy(id, roleDto);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteBy(@PathVariable(value = "id") Long id) {
        return roleService.deleteBy(id);
    }
}
