package com.zjhang.domain.entity;

import java.util.Date;
import javax.persistence.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "operate_log")
public class OperateLog {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 方法名称
     */
    @Column(name = "method_name")
    private String methodName;

    /**
     * 参数名称
     */
    @Column(name = "parameter_name")
    private String parameterName;

    /**
     * 参数值
     */
    @Column(name = "parameter_value")
    private String parameterValue;

    /**
     * 响应时间（毫秒）
     */
    @Column(name = "consume_time")
    private Long consumeTime;

    /**
     * 响应结果
     */
    private String result;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 备注、说明
     */
    private String bz;
}