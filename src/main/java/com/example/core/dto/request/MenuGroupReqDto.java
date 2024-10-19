package com.example.core.dto.request;

import com.example.core.entity.BaseObject;
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

    public MenuGroupReqDto(String menuGroupId, String groupName, String moduleId, String moduleName,
                           String description, Set<MenuActionReqDto> menuActions) {
        this.menuGroupId = menuGroupId;
        this.groupName = groupName;
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.description = description;
        this.menuActions = menuActions;
    }

    public MenuGroupReqDto(AuditableEntityDto auditableEntityDto, String menuGroupId, String groupName, String moduleId,
                           String moduleName, String description, Set<MenuActionReqDto> menuActions) {
        super(auditableEntityDto);
        this.menuGroupId = menuGroupId;
        this.groupName = groupName;
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.description = description;
        this.menuActions = menuActions;
    }

    public MenuGroupReqDto(BaseObject entity, String menuGroupId, String groupName,
                           String moduleId, String moduleName, String description, Set<MenuActionReqDto> menuActions) {
        super(entity);
        this.menuGroupId = menuGroupId;
        this.groupName = groupName;
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.description = description;
        this.menuActions = menuActions;
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


}
