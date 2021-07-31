package com.demo.demo01;

/**
 * @author Fuxx-1
 * @date 2021年07月24日 9:32
 */
public class Proxy {
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    //租房
    public void rent() {
        System.out.println("代理房东租房");
        host.rent();
    }

    //看房
    public void viewHouse() {
        System.out.println("看房中......");
    }

    //收中介费
    public void fare() {
        System.out.println("收中介费......");
    }

    //签合同
    public void sign() {
        System.out.println("签租赁合同......");
    }
}
