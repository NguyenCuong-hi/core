package com.example.core.service.Impl;

import com.example.core.dto.request.RoleDto;
import com.example.core.entity.Role;
import com.example.core.repository.RoleRepository;
import com.example.core.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepo;

    @Override
    public RoleDto getRoleById(Long id) {
        Role role = roleRepo.getById(id);
        return new RoleDto(role);
    }

    @Override
    public RoleDto createBy(RoleDto roleDto) {
        Role role = new Role();
        role.setId(1L);
        this.validRoleDto(roleDto);
        this.setUser(roleDto, role);
        role = roleRepo.save(role);
        return new RoleDto(role);
    }

    @Override
    public RoleDto updateBy(Long id, RoleDto roleDto) {
        Role role = roleRepo.getById(id);
        this.validRoleDto(roleDto);
        this.validBeforeUpdate(role);
        this.setUser(roleDto, role);
        return new RoleDto(role);
    }

    private void validRoleDto(RoleDto userDto) {

    }

    private void validBeforeUpdate(Role role) {

    }

    private void setUser(RoleDto roleDto, Role role) {
        role.setName(roleDto.getName());
        role.setDescription(roleDto.getDescription());
    }


    private void validateBeforeDelete(Role user) {

    }

    @Override
    public Boolean deleteBy(Long id) {
        Role role = roleRepo.getById(id);
        this.validateBeforeDelete(role);
        roleRepo.delete(role);
        return true;
    }
}
