package org.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MutiTest {

    public static void main(String[] args) {
        List<Cla1> list1 = new ArrayList<>();
        list1.add(new Cla1("22", "cde"));
        list1.add(new Cla1("11", "abc"));
        list1.add(new Cla1("44", "cdef"));

        List<Cla2> list2 = new ArrayList<>();
        list2.add(new Cla2("11", "name1"));
        list2.add(new Cla2("22", "name2"));
        list2.add(new Cla2("33", "name3"));
        list2.add(new Cla2("44", "name4"));
        list2.add(new Cla2("aa", "nameaa"));


        System.out.println(combine(list1, list2));
    }

    public static List<Cla3> combine(List<Cla1> claList1, List<Cla2> claList2) {
        List<Cla3> res = new ArrayList<>();
        Map<String, Cla3> map = new HashMap<>();
        for (int i = 0; i < claList1.size(); i++) {
            Cla1 cla1 = claList1.get(i);
            Cla3 cla3 = new Cla3(cla1.id, cla1.type);
            res.add(cla3);
            map.put(cla3.id, cla3);
        }
        for (int i = 0; i < claList2.size(); i++) {
            Cla2 cla2 = claList2.get(i);
            if (map.containsKey(cla2.id)) {
                map.get(cla2.id).name = cla2.name;
            } else {
                res.add(new Cla3(cla2.id, cla2.name, null));
            }
        }
        return res;
    }


}


class Cla1 {
    String id;
    String type;

    public Cla1(String id, String type) {
        this.id = id;
        this.type = type;
    }
}

class Cla2 {
    String id;
    String name;

    public Cla2(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Cla3 {
    String id;
    String name;
    String type;

    public Cla3(String id) {
        this.id = id;
    }

    public Cla3(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public Cla3(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Cla3{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}