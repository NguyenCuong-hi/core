package com.example.core.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "menu_group")
public class MenuGroup extends BaseObject {

    @Column(name = "menu_group_id")
    private String menuGroupId;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "module_id")
    private String moduleId;


    @Column(name = "module_name")
    private String moduleName;

    @Column(name = "description")
    private String description;

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "menuGroup",
            cascade = CascadeType.ALL)
    @Fetch(FetchMode.SELECT)
    private Set<MenuAction> menuActions;

    public MenuGroup() {
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

    public Set<MenuAction> getMenuActions() {
        return menuActions;
    }

    public void setMenuActions(Set<MenuAction> menuActions) {
        this.menuActions = menuActions;
    }
}
