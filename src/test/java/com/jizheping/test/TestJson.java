package com.jizheping.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jizheping.entity.Student;
import com.mysql.cj.xdevapi.JsonArray;

import java.util.ArrayList;
import java.util.List;

public class TestJson {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        student.setSex("男");
        studentList.add(student);

        Student student1 = new Student();
        student1.setId(2);
        student1.setName("李四");
        studentList.add(student1);

        String json = JSONArray.toJSONString(studentList);

        System.out.println(json);
    }
}
