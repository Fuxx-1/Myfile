package com.demo.pojo;

/**
 * @author Fuxx-1
 * @date 2021年07月23日 14:40
 */
public class User {
    public String name;

    public User() {
        System.out.println("User的无参构造被调用");
    }

    public User(String name) {
        System.out.println("User的有参构造被调用");
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
