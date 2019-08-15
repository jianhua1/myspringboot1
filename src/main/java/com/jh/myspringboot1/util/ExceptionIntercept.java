package com.jh.myspringboot1.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
public class ExceptionIntercept {

    @Pointcut(value = "execution(public * com.jh.myspringboot1.controller.*.*(..))")
    public void pointCut() {

    }

    @Around("pointCut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature methodSignature=(MethodSignature)proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Object[] args = proceedingJoinPoint.getArgs();
        for(int i=0;i<args.length;i++){
            if(args[i]==null){
                System.out.println("参数包含空值！");
                break;
            }
        }
        long start = System.currentTimeMillis();
        Object proceed = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("执行方法："+method.getName()+" 方法参数："+ Arrays.toString(proceedingJoinPoint.getArgs())+" 执行时间："+(end-start));

        return proceed;
    }
}
