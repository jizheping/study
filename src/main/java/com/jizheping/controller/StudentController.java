package com.jizheping.controller;

import com.jizheping.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping( "/student" )
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping( "/toStudent" )
    public String toStudent(){
        return "student";
    }

    @RequestMapping( "/toReadJson" )
    public String toReadJson(){
        return "readJson";
    }

    @RequestMapping( "/toTestWebSocket" )
    public String toTestWebSocket(){
        return "testWebSocket";
    }

    @ResponseBody
    @RequestMapping( "/getStudentMessage" )
    public String getStudentMessage(){
        return studentService.getStudentMessage();
    }
}
