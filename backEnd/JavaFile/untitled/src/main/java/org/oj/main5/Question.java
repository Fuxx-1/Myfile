package org.oj.main5;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Question {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();
        list.add(99);
        list.getClass().getMethod("add", Object.class).invoke(list, "reflect");
        System.out.println(list);
    }
}
