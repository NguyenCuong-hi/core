package com.example.core.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement
@Table(name = "role")
@Entity
public class Role extends BaseObject implements GrantedAuthority {

    @Transient
    private static final long serialVersionUID = 1L;

    @Column(name = "role_name", length = 255, nullable = false)
    private String name;

    @Column(name = "role_description", length = 255, nullable = true)
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinTable(
            name = "role_menu_group",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "menu_group_id")},
            foreignKey = @ForeignKey(name = "fk_role_menu_group_id")
    )
    private Set<MenuGroup> menuGroups;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<MenuGroup> getMenuGroups() {
        return menuGroups;
    }

    public void setMenuGroups(Set<MenuGroup> menuGroups) {
        this.menuGroups = menuGroups;
    }

    @Transient
    public String getAuthority() {
        return this.name;
    }


}
