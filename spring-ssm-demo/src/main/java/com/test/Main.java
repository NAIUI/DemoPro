package com.test;

import com.test.config.TestConfiguration;
import com.test.mapper.TestMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(TestConfiguration.class);
        TestMapper mapper = context.getBean(TestMapper.class);
        System.out.println(mapper.getstudent());
    }
}
