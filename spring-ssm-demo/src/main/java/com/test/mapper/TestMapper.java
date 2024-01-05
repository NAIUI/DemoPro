package com.test.mapper;

import com.test.entity.Student;
import org.apache.ibatis.annotations.Select;

public interface TestMapper {

    @Select("select * from Student where sid = 2")
    Student getstudent();
}
