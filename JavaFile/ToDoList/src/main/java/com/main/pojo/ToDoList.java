package com.main.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ToDoList implements Serializable {
    private String username;
    private String date;
    private String List;
}
