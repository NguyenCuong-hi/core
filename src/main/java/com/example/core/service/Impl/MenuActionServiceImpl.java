package com.example.core.service.Impl;

import com.example.core.constans.ErrorCodes;
import com.example.core.constans.ErrorMessage;
import com.example.core.dto.request.MenuActionReqDto;
import com.example.core.dto.request.search.SearchDto;
import com.example.core.dto.response.MenuActionResDto;
import com.example.core.entity.MenuAction;
import com.example.core.exception.ExceptionResponse;
import com.example.core.repository.MenuActionRepository;
import com.example.core.service.MenuActionService;
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
public class MenuActionServiceImpl implements MenuActionService {

    private final MenuActionRepository menuActionRepo;

    private final EntityManager manager;

    @Override
    public Page<MenuActionResDto> searchUser(SearchDto searchDto) {

        int pageIndex = searchDto.getPageIndex();
        int pageSize = searchDto.getPageSize();


        StringBuilder strQuery = new StringBuilder();
        StringBuilder strQueryCount = new StringBuilder();
        this.genWhereClause(strQuery, strQueryCount, searchDto);

        Query query = manager.createQuery(strQuery.toString(), MenuAction.class);
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
        strQuery.append(" SELECT e FROM MenuAction e WHERE (1=1) ");
        strQueryCount.append(" SELECT COUNT(e) FROM MenuAction e WHERE (1=1) ");

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
    public MenuActionResDto getById(Long id) {

        MenuAction menuAction = menuActionRepo.findById(id)
                .orElseThrow(() -> new ExceptionResponse(ErrorCodes.ENTITY_NOT_FOUND,
                        ErrorMessage.ENTITY_NOT_FOUND, id.toString()));
        return new MenuActionResDto(menuAction);
    }

    @Override
    public MenuActionResDto createBy(MenuActionReqDto action) {

        this.validCreateBy(action);
        MenuAction menuAction = new MenuAction();
        this.setValueCreate(action, menuAction);
        menuActionRepo.save(menuAction);
        return new MenuActionResDto(menuAction);
    }

    private void validCreateBy(MenuActionReqDto dto){
//         Todo validate dto, entity
    }

    @Override
    public void setValueCreate(MenuActionReqDto dto, MenuAction action){
        action.setActionName(dto.getActionName());
        action.setActionNameEn(dto.getActionNameEn());
        action.setIsActive(dto.getIsActive());
        action.setDefineType(dto.getDefineType());
        action.setDefinedId(dto.getDefinedId());
        action.setDefinedName(dto.getDefinedName());
    }

    @Override
    public MenuActionResDto updateBy(Long id, MenuActionReqDto action) {

        MenuAction menuAction = menuActionRepo
                .findById(id)
                .orElseThrow(()-> new ExceptionResponse(ErrorCodes.ENTITY_NOT_FOUND,
                        ErrorMessage.ENTITY_NOT_FOUND, id.toString()));
        this.validUpdateBy(action, menuAction);
        this.setValueCreate(action, menuAction);
        return new MenuActionResDto(menuAction);
    }

    private void validUpdateBy(MenuActionReqDto dto, MenuAction action){
//         Todo validate dto, entity
    }

    @Override
    public Boolean deleteBy(Long id) {
        boolean isExistMenuAction = menuActionRepo.existsById(id);
        if (!isExistMenuAction){
            throw new ExceptionResponse(ErrorCodes.ENTITY_NOT_FOUND, ErrorMessage.ENTITY_NOT_FOUND, id.toString());
        }
        menuActionRepo.deleteById(id);
        return true;
    }
}
