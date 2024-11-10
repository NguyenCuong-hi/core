package com.example.core.service;

import com.example.core.dto.request.MenuGroupReqDto;
import com.example.core.dto.request.search.SearchDto;
import com.example.core.dto.response.MenuGroupResDto;
import org.springframework.data.domain.Page;

public interface MenuGroupService {

    Page<MenuGroupResDto> searchBy(SearchDto searchDto);

    MenuGroupResDto getMenuGroup(Long menuGroupId);

    MenuGroupResDto createBy(MenuGroupReqDto menuGroupReqDto);

    MenuGroupResDto updateBy(Long id, MenuGroupReqDto dto);

    Boolean deleteBy(Long id);
}
