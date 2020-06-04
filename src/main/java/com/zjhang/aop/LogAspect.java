package com.zjhang.aop;

import com.alibaba.fastjson.JSON;
import com.zjhang.dao.OperateLogMapper;
import com.zjhang.domain.entity.OperateLog;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author zhengjh
 */
@Aspect
@Component
@Order(1)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class LogAspect {
    private final OperateLogMapper operateLogMapper;

    /**
     * 切入点(execution()最常用的切点函数)
     * 例如: 定义切入点表达式 execution (* com.zjhang.service..*. *(..))
     * 1、execution(): 表达式主体
     * 2、第一个 * 号: 表示返回类型, * 号表示所有的类型
     * 3、包名: 表示需要拦截的包名,后面的两个句点表示当前包和当前包的所有子包,即com.zjhang.service包、子孙包下所有类的方法
     * 4、第二个 * 号: 表示类名, * 号表示所有的类
     * 5、*(..): 最后这个星号表示方法名, * 号表示所有的方法,后面括弧里面表示方法的参数,两个句点表示任何参数
     */
    @Pointcut("execution(public * com.zjhang.service.StudentService.*(..))")
    public void entryPoint() {

    }

    /**
     * 环绕通知（Around advice）
     *
     * @param joinPoint 连接点
     * @return 响应结果
     */
    @Around("entryPoint()")
    public Object around(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();
        Object result = null;
        try {
            // 必须执行，不然不会执行controller
            result = joinPoint.proceed();
            return result;
        } catch (Throwable throwable) {
            throw new RuntimeException("服务异常：" + throwable);
        } finally {
            // 获取响应时间
            long consumedTime = System.currentTimeMillis() - startTime;
            // 获取方法参数值数组
            Object[] args = joinPoint.getArgs();
            String pValue = StringUtils.join(args, ",");
            // 获取签名方法
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            // 获取参数名称
            String[] parameterNames = signature.getParameterNames();
            String pName = StringUtils.join(parameterNames, ",");
            // 获取方法名称
            String methodName = signature.getName();
            log.info("方法名 = {}, 请求参数名称 = {}, 请求参数值 = {}, 响应时间 = {}毫秒, 响应结果 = {}",
                    methodName,
                    pName,
                    pValue,
                    consumedTime,
                    result);
            // 记录到操作日志表
            OperateLog operateLog = OperateLog.builder()
                    .methodName(methodName)
                    .parameterName(pName)
                    .parameterValue(pValue)
                    .consumeTime(consumedTime)
                    .result(JSON.toJSONString(result))
                    .createTime(new Date())
                    .updateTime(new Date())
                    .build();

            this.operateLogMapper.insertSelective(operateLog);
        }
    }
}
