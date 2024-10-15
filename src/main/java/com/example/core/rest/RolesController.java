package com.example.core.rest;

import com.example.core.dto.request.RoleDto;
import com.example.core.dto.request.search.SearchDto;
import com.example.core.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles")
@AllArgsConstructor
public class RolesController {

    private final RoleService roleService;

    @GetMapping("/{id}")
    public RoleDto getById(@PathVariable(value = "id") Long id) {
        return roleService.searchDto(id);
    }

    @GetMapping("/page")
    public Page<RoleDto> getById(@RequestBody SearchDto searchDto) {
        return roleService.searchDto(searchDto);
    }

    @PostMapping
    public RoleDto createBy(@RequestBody RoleDto roleDto) {
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
