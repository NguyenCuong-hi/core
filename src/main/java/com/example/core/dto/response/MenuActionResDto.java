package com.example.core.dto.response;

import com.example.core.dto.request.AuditableEntityDto;
import com.example.core.dto.request.BaseObjectDto;
import com.example.core.entity.MenuAction;

public class MenuActionResDto extends BaseObjectDto {

    private String actionName;

    private String actionNameEn;

    private String isActive;

    private String defineType;

    private String definedId;

    private String definedName;

    public String getActionName() {
        return actionName;
    }

    public String getActionNameEn() {
        return actionNameEn;
    }

    public String getIsActive() {
        return isActive;
    }

    public String getDefineType() {
        return defineType;
    }

    public String getDefinedId() {
        return definedId;
    }

    public String getDefined_name() {
        return definedName;
    }

    public MenuActionResDto() {
    }

    public MenuActionResDto(AuditableEntityDto auditableEntityDto, String actionName,
                            String actionNameEn, String isActive, String defineType, String definedId, String definedName) {
        super(auditableEntityDto);
        this.actionName = actionName;
        this.actionNameEn = actionNameEn;
        this.isActive = isActive;
        this.defineType = defineType;
        this.definedId = definedId;
        this.definedName = definedName;
    }

    public MenuActionResDto(MenuAction action) {

        this.actionName = action.getActionName();
        this.actionNameEn = action.getActionNameEn();
        this.isActive = action.getIsActive();
        this.defineType = action.getDefineType();
        this.definedId = action.getDefinedId();
        this.definedName = action.getDefined_name();
    }
}
