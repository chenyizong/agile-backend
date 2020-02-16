package com.nju.agiledev.po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * id 唯一标示
 * name 权限名称
 * desc 权限描述
 * url  权限路径
 * @Author: chenyizong
 * @Date: 2020-02-11
 */
@Entity
@Table(name="admin_permission")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
public class AdminPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String name;
    private String desc;
    private String url;
}
