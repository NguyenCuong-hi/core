package com.example.core.service;

import com.example.core.dto.request.MenuGroupReqDto;
import com.example.core.dto.request.search.SearchDto;
import com.example.core.dto.response.MenuActionResDto;
import com.example.core.dto.response.MenuGroupResDto;
import org.springframework.data.domain.Page;

public interface MenuGroupService {

    MenuGroupResDto getMenuGroup(Long menuGroupId);

    Page<MenuActionResDto> searchMenuGroup(SearchDto searchDto);

    MenuGroupResDto createBy(MenuGroupReqDto menuGroupReqDto);

    MenuGroupResDto updateBy(Long id, MenuGroupReqDto dto);

    Boolean deleteBy(Long id);
}
