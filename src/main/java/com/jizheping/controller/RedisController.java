package com.jizheping.controller;

import com.jizheping.entity.Student;
import com.jizheping.utils.RedisUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping( "/redis" )
@RestController
public class RedisController {
    @Resource
    private RedisUtil redisUtil;

    @RequestMapping( "/stringSet" )
    public String stringSet(String key){
        Student student = new Student();

        student.setId(1);
        student.setName("张三");
        student.setSex("男");

        boolean flag = redisUtil.set(key, student);

        if(flag){
            return "成功";
        }

        return "失败";
    }
}
