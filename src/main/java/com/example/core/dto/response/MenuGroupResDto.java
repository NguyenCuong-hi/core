package com.example.core.dto.response;

import com.example.core.dto.request.AuditableEntityDto;
import com.example.core.dto.request.BaseObjectDto;
import com.example.core.entity.BaseObject;
import com.example.core.entity.MenuGroup;

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

    public String getGroupName() {
        return groupName;
    }

    public String getModuleId() {
        return moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public String getDescription() {
        return description;
    }

    public Set<MenuActionResDto> getMenuActions() {
        return menuActions;
    }

    public MenuGroupResDto() {
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

    public MenuGroupResDto(AuditableEntityDto auditableEntityDto, String menuGroupId, String groupName,
                           String moduleId, String moduleName, String description, Set<MenuActionResDto> menuActions) {
        super(auditableEntityDto);
        this.menuGroupId = menuGroupId;
        this.groupName = groupName;
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.description = description;
        this.menuActions = menuActions;
    }

    public MenuGroupResDto(BaseObject entity, String menuGroupId, String groupName,
                           String moduleId, String moduleName, String description, Set<MenuActionResDto> menuActions) {
        super(entity);
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
    }

}
