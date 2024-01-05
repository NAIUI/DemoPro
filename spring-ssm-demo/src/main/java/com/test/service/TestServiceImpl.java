package com.test.service;

import com.test.entity.Student;
import com.test.mapper.TestMapper;

import javax.annotation.Resource;

public class TestServiceImpl implements TestService{

    @Resource
    TestMapper mapper;

    @Override
    public Student getStudent() {
        return mapper.getstudent();
    }
}
