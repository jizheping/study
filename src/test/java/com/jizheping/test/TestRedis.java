package com.jizheping.test;

import com.jizheping.entity.Student;
import com.jizheping.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.swing.*;

/**
 * redis测试类
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {
    @Resource
    private RedisUtil redisUtil;

    @Test
    public void testRedis(){
        Student student = new Student();

        student.setId(1);
        student.setName("张三");
        student.setSex("男");

        boolean flag = redisUtil.set("stu1",student);

        if(flag){
            System.out.println("成功!");
        }else{
            System.out.println("失败!");
        }
    }
}
