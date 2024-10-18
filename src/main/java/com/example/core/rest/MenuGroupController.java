package com.example.core.rest;

import com.example.core.service.MenuGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/menu-groups")
@RequiredArgsConstructor
public class MenuGroupController {

    private final MenuGroupService menuGroupService;
}
