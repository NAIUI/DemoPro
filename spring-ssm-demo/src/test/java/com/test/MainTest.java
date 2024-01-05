package com.test;

import com.test.config.TestConfiguration;
import com.test.mapper.TestMapper;
import com.test.service.TestService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class MainTest {

    @Resource
    TestService service;

    @Test
    public void test(){
        System.out.println(service.getStudent());
    }
}
