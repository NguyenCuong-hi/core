package com.example.core.rest;

import com.example.core.service.MenuActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/menu-actions")
@RequiredArgsConstructor
public class MenuActionController {

    private final MenuActionService menuActionService;
}
