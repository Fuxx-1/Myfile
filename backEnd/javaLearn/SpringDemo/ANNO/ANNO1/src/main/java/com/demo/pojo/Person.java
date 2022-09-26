package com.demo.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * @author Fuxx-1
 * @date 2021年07月23日 16:33
 */
public class Person {

    @Autowired(required = false)
    @Qualifier("dog")
    private Dog dog;
    @Resource(name = "cat")
    private Cat cat;
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "dog=" + dog.shout() +
                ", cat=" + cat.shout() +
                ", name='" + name + '\'' +
                '}';
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
