package com.example.core.service;

import com.example.core.dto.request.UserGroupDto;

public interface UserGroupService {

    UserGroupDto getUserGroup(Long roleId);

    UserGroupDto createBy(UserGroupDto role);

    UserGroupDto updateBy(Long id, UserGroupDto role);

    Boolean deleteBy(Long id);
}
