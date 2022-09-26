package com.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Fuxx-1
 * @date 2021年07月24日 15:56
 */
@Component
@Aspect
public class AnnotationPointCut {

    @Before("execution(* com.service.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("前：");
    }

    @After("execution(* com.service.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("后：");
    }

    @Around("execution(* com.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("前~");

        System.out.println(proceedingJoinPoint.getSignature());
        try {
            Object proceed = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("后~");
    }
}
