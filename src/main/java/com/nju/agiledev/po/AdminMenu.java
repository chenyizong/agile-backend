package com.nju.agiledev.po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * id       唯一标示
 * path     与vue中的路径对应，即地址路径
 * name     与vue中的name属性对应
 * name_c   name的中文名称，用于渲染导航栏的界面
 * icon_cls element图标类名，用于渲染菜单名称前的小图标
 * component 组件名，用于解析路由对应的组件
 * parent_id 父节点 id，用于存储导航栏层级关系
 *
 * @Author: chenyizong
 * @Date: 2020-02-11
 */
@Entity
@Table(name = "admin_menu")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
public class AdminMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String path;
    private String name;
    private String nameZh;
    private String iconCls;
    private String component;
    private int parentId;
    @Transient
    /**
     * 存储子节点（数据库中没有该属性）
     */
    private List<AdminMenu> children;
}
