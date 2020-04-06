package com.nju.agiledev.po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * @Author: zhuanggangqing
 * @Description:
 * @Date: Create in 4:18 下午 2020/4/5
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

    String title;
    String cover;
    String author;
    String press;
    String pyear;
    double score;

    String content_des;
    String author_des;
    String book_type;
}
