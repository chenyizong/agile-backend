package com.nju.agiledev.po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.sql.Date;

/**
 * @Author: chenyizong
 * @Date: 2020-02-06
 *
 * articleTitle 文章名称
 * articleContentHtml 文章html
 * articleContentMd md原文
 * articleAbstract 文章摘要
 * articleCover  文章标题
 * articleDate  发布日期
 */
@Data
@Entity
@Table(name="jotter_article")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class JotterArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String articleTitle;
    private String articleContentHtml;
    private String articleContentMd;
    private String articleAbstract;
    private String articleCover;
    private Date articleDate;

}
