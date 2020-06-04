package com.zjhang.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author zhengjh
 */
@Aspect
@Component
// order值越小，优先级越高
@Order(0)
@Slf4j
public class AuthAspect {
    @Around("@annotation(com.zjhang.aop.CheckAuth)")
    public Object checkAuth(ProceedingJoinPoint joinPoint) {
        try {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            CheckAuth annotation = method.getAnnotation(CheckAuth.class);
            String operator = annotation.operator();
            log.info("操作人 = {}", operator);
            // TODO 根据请求头header中的token信息验证权限

            return joinPoint.proceed();
        } catch (Throwable throwable) {
            throw new RuntimeException("服务异常：" + throwable);
        }
    }
}
