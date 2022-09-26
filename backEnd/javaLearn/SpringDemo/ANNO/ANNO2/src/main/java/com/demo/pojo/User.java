package com.demo.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Fuxx-1
 * @date 2021年07月23日 17:18
 */
@Component
public class User {

    @Value("Fuxx-1")
    public String name;
}
