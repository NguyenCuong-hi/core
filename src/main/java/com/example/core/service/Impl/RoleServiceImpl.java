package com.example.core.service.Impl;

import com.example.core.constans.ErrorCodes;
import com.example.core.constans.ErrorMessage;
import com.example.core.dto.request.RoleDto;
import com.example.core.dto.request.search.SearchDto;
import com.example.core.entity.Role;
import com.example.core.exception.ExceptionResponse;
import com.example.core.repository.RoleRepository;
import com.example.core.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepo;

    @Override
    public RoleDto searchDto(Long id) {
        Role role = roleRepo.findById(id).orElseThrow(()->
                new ExceptionResponse(ErrorCodes.ENTITY_NOT_FOUND, ErrorMessage.ENTITY_NOT_FOUND, id.toString()));
        return new RoleDto(role);
    }

    @Override
    public Page<RoleDto> searchDto(SearchDto searchDto) {
        List<Role> roles = roleRepo.findAll();
        Pageable pageable = PageRequest.of(searchDto.getPageIndex(), searchDto.getPageSize());
        return new PageImpl(roles, pageable, roles.size());
    }

    @Override
    public RoleDto createBy(RoleDto roleDto) {
        Role role = new Role();
        this.validRoleDto(roleDto);
        this.setUser(roleDto, role);
        role = roleRepo.save(role);
        return new RoleDto(role);
    }

    @Override
    public RoleDto updateBy(Long id, RoleDto roleDto) {
        Role role = roleRepo.findById(id).orElseThrow(()->
                new ExceptionResponse(ErrorCodes.ENTITY_NOT_FOUND, ErrorMessage.ENTITY_NOT_FOUND, id.toString()));
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
        Role role = roleRepo.findById(id).orElseThrow(()->
                new ExceptionResponse(ErrorCodes.ENTITY_NOT_FOUND, ErrorMessage.ENTITY_NOT_FOUND, id.toString()));
        this.validateBeforeDelete(role);
        roleRepo.delete(role);
        return true;
    }
}
