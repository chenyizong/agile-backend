package com.nju.agiledev.po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * book表：
 * id 书本id
 * category 所属目录（外健cid）
 * cover 书本图片的url
 * title 书本名称
 * author 书本作者
 * date 上线日期
 * press 书本出版社
 * abs 书本简介
 */
@Entity
@Table(name = "book")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @ManyToOne
    @JoinColumn(name="cid")
    private Category category;

    String cover;
    String title;
    String author;
    String date;
    String press;
    String abs;
}
