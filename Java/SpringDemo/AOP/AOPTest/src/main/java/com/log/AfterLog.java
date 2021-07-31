package com.log;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Fuxx-1
 * @date 2021年07月24日 10:51
 */
@Component
public class AfterLog implements AfterReturningAdvice {
    /**
     *
     * @param o 返回值
     * @param method 要执行目标对象的方法
     * @param objects 参数
     * @param o1 目标对象
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("执行了" + o1.getClass().getName() + "的" + method.getName());
    }
}
