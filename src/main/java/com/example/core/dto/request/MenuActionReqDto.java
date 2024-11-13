package com.example.core.dto.request;

import com.example.core.entity.MenuAction;

public class MenuActionReqDto extends BaseObjectDto {

    private String actionName;

    private String actionNameEn;

    private String isActive;

    private String defineType;

    private String definedId;

    private String definedName;

    private MenuGroupReqDto menuGroup;

    public MenuActionReqDto() {
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

    public MenuGroupReqDto getMenuGroup() {
        return menuGroup;
    }

    public void setMenuGroup(MenuGroupReqDto menuGroup) {
        this.menuGroup = menuGroup;
    }

    public MenuAction toEntity() {
        MenuAction action = new MenuAction();

        return action;
    }

}
