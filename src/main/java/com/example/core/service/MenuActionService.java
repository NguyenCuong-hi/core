package com.example.core.service;

import com.example.core.dto.request.MenuActionReqDto;
import com.example.core.dto.request.UserDto;
import com.example.core.dto.request.search.SearchDto;
import com.example.core.dto.response.MenuActionResDto;
import org.springframework.data.domain.Page;

public interface MenuActionService {

    Page<MenuActionResDto> searchUser(SearchDto searchDto);

    MenuActionResDto getById(Long id);

    MenuActionResDto createBy(MenuActionReqDto action);

    MenuActionResDto updateBy(Long id, MenuActionReqDto action);

    Boolean deleteBy(Long id);
}
