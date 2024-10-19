package com.example.core.service;

import com.example.core.dto.request.MenuActionReqDto;
import com.example.core.dto.request.search.SearchDto;
import com.example.core.dto.response.MenuActionResDto;
import com.example.core.entity.MenuAction;
import org.springframework.data.domain.Page;

public interface MenuActionService {

    Page<MenuActionResDto> searchUser(SearchDto searchDto);

    MenuActionResDto getById(Long id);

    MenuActionResDto createBy(MenuActionReqDto action);

    void setValueCreate(MenuActionReqDto dto, MenuAction action);

    MenuActionResDto updateBy(Long id, MenuActionReqDto action);

    Boolean deleteBy(Long id);
}
