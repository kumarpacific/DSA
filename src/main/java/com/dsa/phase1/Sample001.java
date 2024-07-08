package com.dsa.phase1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sample001 {
    public static void main(String[] args) {
        HashMap<Employee,Employee> map = new HashMap<>();
        Employee e1 = new Employee(1, "Prax");
        map.put(e1,e1);
        System.out.println("e1 -> "+e1);
        System.out.println("map -> "+map);

        e1.setId(2);

        System.out.println("e1 -> "+e1);
        System.out.println("map -> "+map);

        final List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(2);


        System.out.println(list);

    }
}

class Employee{
    int id;
    String name;
    public Employee(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

//    @Override
//    public String toString() {
//        return "Employee{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }
}
