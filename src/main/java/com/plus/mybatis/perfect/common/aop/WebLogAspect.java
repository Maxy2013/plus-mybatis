package com.plus.mybatis.perfect.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Aspect
@Component
public class WebLogAspect {

    @Pointcut("execution(* com.plus.mybatis.perfect.business.controller.*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("before : " + LocalTime.now());

        Signature signature = joinPoint.getSignature();

        Object[] args = joinPoint.getArgs();
        Object arg = args[0];
        System.out.println(signature.toLongString() + "请求参数是：" + arg);
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfter(Object ret) {
        System.out.println("after : " + LocalTime.now());
        System.out.println("返回参数是 : " + ret);
    }
}
