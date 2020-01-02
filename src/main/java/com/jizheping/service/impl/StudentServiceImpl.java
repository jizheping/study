package com.jizheping.service.impl;

import com.alibaba.fastjson.JSON;
import com.jizheping.entity.Student;
import com.jizheping.mapper.StudentMapper;
import com.jizheping.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public String getStudentMessage() {
        List<Student> studentList = studentMapper.getStudentMessage();

        String json = JSON.toJSONString(studentList);

        System.out.println(json);

        return json;
    }
}
