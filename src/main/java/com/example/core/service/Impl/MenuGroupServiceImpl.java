package com.example.core.service.Impl;

import com.example.core.constans.ErrorCodes;
import com.example.core.constans.ErrorMessage;
import com.example.core.dto.request.MenuActionReqDto;
import com.example.core.dto.request.MenuGroupReqDto;
import com.example.core.dto.request.search.SearchDto;
import com.example.core.dto.response.MenuActionResDto;
import com.example.core.dto.response.MenuGroupResDto;
import com.example.core.entity.MenuAction;
import com.example.core.entity.MenuGroup;
import com.example.core.exception.ExceptionResponse;
import com.example.core.repository.MenuActionRepository;
import com.example.core.repository.MenuGroupRepository;
import com.example.core.service.MenuActionService;
import com.example.core.service.MenuGroupService;
import liquibase.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MenuGroupServiceImpl implements MenuGroupService {

    private final MenuGroupRepository menuGroupRepo;

    private final MenuActionService menuActionService;

    private final MenuActionRepository menuActionRepo;

    private final EntityManager manager;

    @Override
    public MenuGroupResDto getMenuGroup(Long menuGroupId) {
        MenuGroup menuGroup = menuGroupRepo.findById(menuGroupId)
                .orElseThrow(() -> new ExceptionResponse(ErrorCodes.ENTITY_NOT_FOUND,
                        ErrorMessage.ENTITY_NOT_FOUND, menuGroupId.toString()));
        return new MenuGroupResDto(menuGroup);
    }

    @Override
    public Page<MenuActionResDto> searchMenuGroup(SearchDto searchDto) {

        int pageIndex = searchDto.getPageIndex();
        int pageSize = searchDto.getPageSize();


        StringBuilder strQuery = new StringBuilder();
        StringBuilder strQueryCount = new StringBuilder();
        this.genWhereClause(strQuery, strQueryCount, searchDto);

        Query query = manager.createQuery(strQuery.toString(), MenuGroup.class);
        Query qCount = manager.createQuery(strQueryCount.toString());
        this.setParameter(query, qCount, searchDto);

        int startPosition = pageIndex * pageSize;
        query.setFirstResult(startPosition);
        query.setMaxResults(pageSize);
        List<MenuAction> entities = query.getResultList();
        long count = (long) qCount.getSingleResult();
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        return new PageImpl(entities, pageable, count);
    }

    private void genWhereClause(StringBuilder strQuery, StringBuilder strQueryCount, SearchDto searchDto){
        strQuery.append(" SELECT e FROM MenuGroup e WHERE (1=1) ");
        strQueryCount.append(" SELECT COUNT(e) FROM MenuGroup e WHERE (1=1) ");

        if (StringUtil.isNotEmpty(searchDto.getKeyword())){
            strQuery.append("AND (" +
                    " e.actionName LIKE :keyword " +
                    " OR e.actionNameEn LIKE :keyword " +
                    " OR e.defineType LIKE :keyword " +
                    " OR e.definedName LIKE :keyword " +
                    " ) ");

            strQueryCount.append("AND (" +
                    " e.actionName LIKE :keyword " +
                    " OR e.actionNameEn LIKE :keyword " +
                    " OR e.defineType LIKE :keyword " +
                    " OR e.definedName LIKE :keyword " +
                    " ) ");
        }
    }

    private void setParameter(Query query, Query queryCount, SearchDto searchDto){
        if (StringUtil.isNotEmpty(searchDto.getKeyword())){
            query.setParameter("keyword", '%' + searchDto.getKeyword() + '%');
            queryCount.setParameter("keyword", '%' + searchDto.getKeyword() + '%');
        }
    }

    @Override
    public MenuGroupResDto createBy(MenuGroupReqDto menuGroupReqDto) {
        this.validCreateBy(menuGroupReqDto);
        MenuGroup menuGroup = new MenuGroup();
        this.setValueMenuGroup(menuGroupReqDto, menuGroup);
        menuGroupRepo.save(menuGroup);
        return new MenuGroupResDto(menuGroup);
    }

    private void validCreateBy(MenuGroupReqDto menuGroupReqDto) {

    }

    private void setValueMenuGroup(MenuGroupReqDto menuGroupReqDto, MenuGroup menuGroup) {
        menuGroup.setMenuGroupId(menuGroupReqDto.getMenuGroupId());
        menuGroup.setGroupName(menuGroupReqDto.getGroupName());
        menuGroup.setDescription(menuGroupReqDto.getDescription());
        menuGroup.setModuleId(menuGroupReqDto.getModuleId());
        menuGroup.setModuleName(menuGroupReqDto.getModuleName());
        Set<MenuAction> menuActions = new HashSet<>();
        for (MenuActionReqDto reqDto : menuGroupReqDto.getMenuActions()) {
            MenuAction entity = new MenuAction();
            if (!Objects.isNull(reqDto.getId()) && menuActionRepo.existsById(reqDto.getId())) {
                entity = menuActionRepo.findById(reqDto.getId()).orElseThrow(() ->
                        new ExceptionResponse(ErrorCodes.ENTITY_NOT_FOUND, ErrorMessage.ENTITY_NOT_FOUND, reqDto.getId().toString()));
            }
            menuActionService.setValueCreate(reqDto, entity);
            menuActions.add(entity);

        }
        menuGroup.setMenuActions(menuActions);

    }

    @Override
    public MenuGroupResDto updateBy(Long id, MenuGroupReqDto dto) {
        this.validUpdateBy(dto);
        MenuGroup menuGroup = menuGroupRepo.findById(id).orElseThrow(() ->
                new ExceptionResponse(ErrorCodes.ENTITY_NOT_FOUND, ErrorMessage.ENTITY_NOT_FOUND, id.toString()));
        this.setValueMenuGroup(dto, menuGroup);

        return new MenuGroupResDto(menuGroup);
    }

    private void validUpdateBy(MenuGroupReqDto reqDto) {

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
