package com.example.core.service.Impl;

import com.example.core.constans.ErrorCodes;
import com.example.core.constans.ErrorMessage;
import com.example.core.dto.request.MenuGroupReqDto;
import com.example.core.dto.request.search.SearchDto;
import com.example.core.dto.response.MenuActionResDto;
import com.example.core.dto.response.MenuGroupResDto;
import com.example.core.entity.MenuAction;
import com.example.core.entity.MenuGroup;
import com.example.core.exception.ExceptionResponse;
import com.example.core.repository.MenuGroupRepository;
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
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuGroupServiceImpl implements MenuGroupService {

    private final MenuGroupRepository menuGroupRepo;
    private final EntityManager manager;

    @Override
    public Page<MenuGroupResDto> searchBy(SearchDto searchDto) {

        List<MenuGroup> menuGroups = menuGroupRepo.findAll();
        Pageable pageable = PageRequest.of(searchDto.getPageIndex(), searchDto.getPageSize());
        return new PageImpl(menuGroups, pageable, menuGroups.size());
    }

    @Override
    public MenuGroupResDto getMenuGroup(Long menuGroupId) {
        MenuGroup menuGroup = menuGroupRepo.findById(menuGroupId)
                .orElseThrow(() -> new ExceptionResponse(ErrorCodes.ENTITY_NOT_FOUND,
                        ErrorMessage.ENTITY_NOT_FOUND, menuGroupId.toString()));
        return new MenuGroupResDto(menuGroup);
    }

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

    private void genWhereClause(StringBuilder strQuery, StringBuilder strQueryCount, SearchDto searchDto) {
        strQuery.append(" SELECT e FROM MenuGroup e WHERE (1=1) ");
        strQueryCount.append(" SELECT COUNT(e) FROM MenuGroup e WHERE (1=1) ");

        if (StringUtil.isNotEmpty(searchDto.getKeyword())) {
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

    private void setParameter(Query query, Query queryCount, SearchDto searchDto) {
        if (StringUtil.isNotEmpty(searchDto.getKeyword())) {
            query.setParameter("keyword", '%' + searchDto.getKeyword() + '%');
            queryCount.setParameter("keyword", '%' + searchDto.getKeyword() + '%');
        }
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
