package com.example.core.rest;

import com.example.core.dto.request.MenuGroupReqDto;
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
    public MenuGroupResDto createBy(@RequestBody MenuGroupReqDto menuGroupReqDto) {
        return menuGroupService.createBy(menuGroupReqDto);
    }

    @PutMapping("/{id}")
    public MenuGroupResDto updateBy(@PathVariable(value = "id") Long id,
                            @RequestBody MenuGroupReqDto menuGroupReqDto) {
        return menuGroupService.updateBy(id, menuGroupReqDto);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteBy(@PathVariable(value = "id") Long id) {
        return menuGroupService.deleteBy(id);
    }
}
