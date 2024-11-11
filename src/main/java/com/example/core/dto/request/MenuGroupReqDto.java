package com.example.core.dto.request;

import com.example.core.entity.MenuAction;
import com.example.core.entity.MenuGroup;

import java.util.HashSet;
import java.util.Set;

public class MenuGroupReqDto extends BaseObjectDto {

    private String menuGroupId;

    private String groupName;

    private String moduleId;

    private String moduleName;

    private String description;

    private Set<MenuActionReqDto> menuActions;

    public MenuGroupReqDto() {
    }

    public String getMenuGroupId() {
        return menuGroupId;
    }

    public void setMenuGroupId(String menuGroupId) {
        this.menuGroupId = menuGroupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<MenuActionReqDto> getMenuActions() {
        return menuActions;
    }

    public void setMenuActions(Set<MenuActionReqDto> menuActions) {
        this.menuActions = menuActions;
    }

    public MenuGroup toEntity() {
        MenuGroup menuGroup = new MenuGroup();
        menuGroup.setMenuGroupId(this.getMenuGroupId());
        menuGroup.setGroupName(this.getGroupName());
        menuGroup.setModuleId(this.getModuleId());
        menuGroup.setModuleName(this.getModuleName());
        menuGroup.setDescription(this.getDescription());

        Set<MenuAction> actions = new HashSet<>();
        for (MenuActionReqDto req : this.getMenuActions()) {
            MenuAction action = req.toEntity();
            actions.add(action);
        }
        menuGroup.setMenuActions(actions);
        return menuGroup;

    }
}
