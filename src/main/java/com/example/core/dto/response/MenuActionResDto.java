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

    private MenuGroupResDto menuGroup;

    public MenuActionResDto(String actionName, String actionNameEn, String isActive, String defineType,
                            String definedId, String definedName, MenuGroupResDto menuGroup) {
        this.actionName = actionName;
        this.actionNameEn = actionNameEn;
        this.isActive = isActive;
        this.defineType = defineType;
        this.definedId = definedId;
        this.definedName = definedName;
        this.menuGroup = menuGroup;
    }

    public MenuActionResDto(AuditableEntityDto auditableEntityDto, String actionName,
                            String actionNameEn, String isActive, String defineType, String definedId,
                            String definedName, MenuGroupResDto menuGroup) {
        super(auditableEntityDto);
        this.actionName = actionName;
        this.actionNameEn = actionNameEn;
        this.isActive = isActive;
        this.defineType = defineType;
        this.definedId = definedId;
        this.definedName = definedName;
        this.menuGroup = menuGroup;
    }

    public MenuActionResDto(MenuAction menuAction) {
        this.actionName = menuAction.getActionName();
        this.actionNameEn = menuAction.getActionNameEn();
        this.isActive = menuAction.getIsActive();
        this.defineType = menuAction.getDefineType();
        this.definedId = menuAction.getDefinedId();
        this.definedName = menuAction.getDefinedName();
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getActionNameEn() {
        return actionNameEn;
    }

    public void setActionNameEn(String actionNameEn) {
        this.actionNameEn = actionNameEn;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getDefineType() {
        return defineType;
    }

    public void setDefineType(String defineType) {
        this.defineType = defineType;
    }

    public String getDefinedId() {
        return definedId;
    }

    public void setDefinedId(String definedId) {
        this.definedId = definedId;
    }

    public String getDefinedName() {
        return definedName;
    }

    public void setDefinedName(String definedName) {
        this.definedName = definedName;
    }

    public MenuGroupResDto getMenuGroup() {
        return menuGroup;
    }

    public void setMenuGroup(MenuGroupResDto menuGroup) {
        this.menuGroup = menuGroup;
    }

}
