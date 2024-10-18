package com.example.core.service.Impl;

import com.example.core.constans.ErrorCodes;
import com.example.core.constans.ErrorMessage;
import com.example.core.dto.request.MenuGroupReqDto;
import com.example.core.dto.request.MenuGroupResDto;
import com.example.core.dto.response.MenuGroupResDto;
import com.example.core.entity.MenuGroup;
import com.example.core.entity.UserGroup;
import com.example.core.exception.ExceptionResponse;
import com.example.core.repository.MenuGroupRepository;
import com.example.core.service.MenuGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuGroupServiceImpl implements MenuGroupService {

    private final MenuGroupRepository menuGroupRepo;

    @Override
    public MenuGroupResDto getMenuGroup(Long menuGroupId) {
        MenuGroup menuGroup = menuGroupRepo.findById(menuGroupId)
                .orElseThrow(()-> new ExceptionResponse(ErrorCodes.ENTITY_NOT_FOUND,
                        ErrorMessage.ENTITY_NOT_FOUND, menuGroupId.toString()));
        return new MenuGroupResDto(menuGroup);
    }

    @Override
    public MenuGroupResDto createBy(MenuGroupReqDto MenuGroupResDto) {
        this.validCreateBy(MenuGroupResDto);
        UserGroup userGroup = MenuGroupResDto.toEntity();
        userGrRepo.save(userGroup);
        return new MenuGroupResDto(userGroup);
    }

    private void validCreateBy(MenuGroupResDto MenuGroupResDto) {

    }


    @Override
    public MenuGroupResDto updateBy(Long id, MenuGroupResDto dto) {
        this.validUpdateBy(dto);
        UserGroup userGroup = userGrRepo.findById(id).orElseThrow();
        this.setUserGrUpdate(dto, userGroup);

        return new MenuGroupResDto(userGroup);
    }

    private void validUpdateBy(MenuGroupResDto MenuGroupResDto) {

    }

    private void setUserGrUpdate(MenuGroupResDto dto, UserGroup entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
    }


    @Override
    public Boolean deleteBy(Long id) {
        this.isExistUserGr(id);
        userGrRepo.deleteById(id);
        return true;
    }

    public void isExistUserGr(Long id) {

    }
}
}
