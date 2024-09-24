package com.example.core.service;

import com.example.core.dto.request.RoleDto;
import org.springframework.stereotype.Service;


public interface RoleService {

    RoleDto getRoleById(Long roleId);

    RoleDto createBy(RoleDto role);

    RoleDto updateBy(Long id, RoleDto role);

    Boolean deleteBy(Long id);
}
