package com.example.core.service.Impl;

import com.example.core.constans.ErrorCodes;
import com.example.core.constans.ErrorMessage;
import com.example.core.dto.request.MenuGroupReqDto;
import com.example.core.dto.request.search.SearchDto;
import com.example.core.dto.response.MenuGroupResDto;
import com.example.core.entity.MenuGroup;
import com.example.core.exception.ExceptionResponse;
import com.example.core.repository.MenuGroupRepository;
import com.example.core.service.MenuGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuGroupServiceImpl implements MenuGroupService {

    private final MenuGroupRepository menuGroupRepo;

    @Override
    public Page<MenuGroupResDto> searchBy(SearchDto searchDto) {

        List<MenuGroup> menuGroups = menuGroupRepo.findAll();
        Pageable pageable = PageRequest.of(searchDto.getPageIndex(), searchDto.getPageSize());
        return new PageImpl(menuGroups, pageable, menuGroups.size());
    }

    @Override
    public MenuGroupResDto getMenuGroup(Long menuGroupId) {
        MenuGroup menuGroup = menuGroupRepo.findById(menuGroupId)
                .orElseThrow(()-> new ExceptionResponse(ErrorCodes.ENTITY_NOT_FOUND,
                        ErrorMessage.ENTITY_NOT_FOUND, menuGroupId.toString()));
        return new MenuGroupResDto(menuGroup);
    }

    @Override
    public MenuGroupResDto createBy(MenuGroupReqDto menuGroupReqDto) {
        this.validCreateBy(menuGroupReqDto);
        MenuGroup userGroup = menuGroupReqDto.toEntity();
        menuGroupRepo.save(userGroup);
        return new MenuGroupResDto(userGroup);
    }

    private void validCreateBy(MenuGroupReqDto menuGroupReqDto) {

    }


    @Override
    public MenuGroupResDto updateBy(Long id, MenuGroupReqDto dto) {
        this.validUpdateBy(dto);
        MenuGroup menuGroup = menuGroupRepo.findById(id).orElseThrow();
        this.setMenuGroupUpdate(dto, menuGroup);

        return new MenuGroupResDto(menuGroup);
    }

    private void validUpdateBy(MenuGroupReqDto menuGroupReqDto) {

    }

    private void setMenuGroupUpdate(MenuGroupReqDto dto, MenuGroup entity) {
        entity.setDescription(dto.getDescription());
    }


    @Override
    public Boolean deleteBy(Long id) {
        this.isExistUserGr(id);
        menuGroupRepo.deleteById(id);
        return true;
    }

    public void isExistUserGr(Long id) {

    }
}
