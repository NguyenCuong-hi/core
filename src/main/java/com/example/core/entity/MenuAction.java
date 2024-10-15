package com.example.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "menu_action")
public class MenuAction extends BaseObject{

    @Column(name = "action_name")
    private String actionName;

    @Column(name = "action_name_en")
    private String actionNameEn;

    @Column(name = "is_active")
    private String isActive;

    @Column(name = "defined_type")
    private String defineType;

    @Column(name = "defined_id")
    private String definedId;

    @Column(name = "defined_name")
    private String defined_name;

    @ManyToOne
    @JoinColumn(name = "menu_group_id",
    foreignKey = @ForeignKey(name = "fk_menu_action_menu_group_id"))
    private MenuGroup menuGroup;

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

    public String getDefined_name() {
        return defined_name;
    }

    public void setDefined_name(String defined_name) {
        this.defined_name = defined_name;
    }

    public MenuGroup getMenuGroup() {
        return menuGroup;
    }

    public void setMenuGroup(MenuGroup menuGroup) {
        this.menuGroup = menuGroup;
    }
}
