package com.nju.agiledev.po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * id       唯一标示
 * name     角色名称
 * name_c   角色中文名称
 * enabled
 * perms    权限集合
 * menus    菜单集合
 * @Author: chenyizong
 * @Date: 2020-02-11
 */
@Entity
@Table(name = "admin_role")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
public class AdminRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String name;
    @Column(name = "name_c")
    private String nameC;
    private boolean enabled;
    @Transient
    private List<AdminPermission> perms;
    @Transient
    private List<AdminMenu> menus;
}
