package com.example.core.service;

import com.example.core.dto.request.RoleDto;
import com.example.core.dto.request.search.SearchDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


public interface RoleService {

    RoleDto searchDto(Long roleId);

    Page<RoleDto> searchDto(SearchDto searchDto);

    RoleDto createBy(RoleDto role);

    RoleDto updateBy(Long id, RoleDto role);

    Boolean deleteBy(Long id);
}
