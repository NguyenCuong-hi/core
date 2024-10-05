package com.example.core.service.Impl;

import com.example.core.dto.request.UserGroupDto;
import com.example.core.entity.UserGroup;
import com.example.core.repository.UserGroupRepository;
import com.example.core.service.UserGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserGroupServiceImp implements UserGroupService {

    private final UserGroupRepository userGrRepo;


    @Override
    public UserGroupDto getUserGroup(Long userGrId) {
        UserGroup userGroup = userGrRepo.findById(userGrId).orElseThrow();
        return new UserGroupDto(userGroup);
    }

    @Override
    public UserGroupDto createBy(UserGroupDto userGroupDto) {
        this.validCreateBy(userGroupDto);
        UserGroup userGroup = userGroupDto.toEntity();
        userGrRepo.save(userGroup);
        return new UserGroupDto(userGroup);
    }

    private void validCreateBy(UserGroupDto userGroupDto){

    }


    @Override
    public UserGroupDto updateBy(Long id, UserGroupDto dto) {
        this.validUpdateBy(dto);
        UserGroup userGroup = userGrRepo.findById(id).orElseThrow();
        this.setUserGrUpdate(dto, userGroup);

        return new UserGroupDto(userGroup);
    }

    private void validUpdateBy(UserGroupDto userGroupDto){

    }

    private void setUserGrUpdate(UserGroupDto dto, UserGroup entity){
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
    }


    @Override
    public Boolean deleteBy(Long id) {
        this.isExistUserGr(id);
        userGrRepo.deleteById(id);
        return true;
    }

    public void isExistUserGr(Long id){

    }
}
