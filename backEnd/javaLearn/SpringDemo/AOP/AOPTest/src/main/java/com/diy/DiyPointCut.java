package com.diy;

import org.springframework.stereotype.Component;

/**
 * @author Fuxx-1
 * @date 2021年07月24日 15:45
 */
@Component
public class DiyPointCut {

    public void before() {
        System.out.println("=====方法执行前=====");
    }

    public void after() {
        System.out.println("-----方法执行后-----");
    }

}
