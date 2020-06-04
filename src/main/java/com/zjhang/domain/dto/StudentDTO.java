package com.zjhang.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhengjh
 * @date 2020/6/3 15:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {
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
