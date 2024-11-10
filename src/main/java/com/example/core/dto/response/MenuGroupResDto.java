package com.example.core.dto.response;

import com.example.core.dto.request.BaseObjectDto;
import com.example.core.entity.MenuAction;
import com.example.core.entity.MenuGroup;

import java.util.HashSet;
import java.util.Set;

public class MenuGroupResDto extends BaseObjectDto {

    private String menuGroupId;

    private String groupName;

    private String moduleId;

    private String moduleName;

    private String description;

    private Set<MenuActionResDto> menuActions;

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

    public void setMenuActions(Set<MenuActionResDto> menuActions) {
        this.menuActions = menuActions;
    }


    public MenuGroupResDto(String menuGroupId, String groupName, String moduleId, String moduleName,
                           String description, Set<MenuActionResDto> menuActions) {
        this.menuGroupId = menuGroupId;
        this.groupName = groupName;
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.description = description;
        this.menuActions = menuActions;
    }

    public MenuGroupResDto(MenuGroup menuGroup) {
        this.menuGroupId = menuGroup.getMenuGroupId();
        this.groupName = menuGroup.getGroupName();
        this.moduleId = menuGroup.getModuleId();
        this.moduleName = menuGroup.getModuleName();
        this.description = menuGroup.getDescription();

        Set<MenuActionResDto> menuActions = new HashSet<>();
        for (MenuAction action : menuGroup.getMenuActions()) {
            MenuActionResDto actionResDto = new MenuActionResDto(action);
            menuActions.add(actionResDto);
        }
        this.menuActions = menuActions;
    }


}
