package com.zjhang.aop;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author zhengjh
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckAuth {
    /**
     * 操作人
     *
     * @return
     */
    String operator();
}
