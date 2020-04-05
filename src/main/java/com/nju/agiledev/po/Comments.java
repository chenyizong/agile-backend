package com.nju.agiledev.po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * @Author: zhuanggangqing
 * @Description:
 * @Date: Create in 4:21 下午 2020/4/5
 */
@Entity
@Table(name = "book")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    int book_id;
    String content;
    String p_name;
    double p_score;
    String p_time;
    int praise;
}
