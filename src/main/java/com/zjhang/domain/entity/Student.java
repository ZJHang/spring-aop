package com.zjhang.domain.entity;

import javax.persistence.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "student")
public class Student {
    /**
     * 学生ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 学生学号
     */
    private Integer sno;

    /**
     * 学生姓名
     */
    private String sname;

    /**
     * 学生年龄
     */
    private Integer sage;

    /**
     * 学生性别
     */
    private String sex;

    /**
     * 学生联系方式
     */
    private String tel;

    /**
     * 学生电子邮箱
     */
    private String email;

    /**
     * 学生家庭住址
     */
    private String address;
}