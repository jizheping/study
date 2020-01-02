package com.jizheping.test;

import com.jizheping.entity.Student;

public class TestForStudy {
    public static void main(String[] args) {
        get(Student.class);
    }

    public static void get(Class<?> clazz){
        String className = clazz.getName();

        System.out.println(className);
    }
}
