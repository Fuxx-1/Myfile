package com.demo.demo01;

/**
 * 房东
 * @author Fuxx-1
 * @date 2021年07月24日 9:28
 */
public class Host implements Rent{
    @Override
    public void rent() {
        System.out.println("房东要出租房子");
    }
}
