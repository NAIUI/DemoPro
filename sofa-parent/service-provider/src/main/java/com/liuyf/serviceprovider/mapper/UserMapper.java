package com.liuyf.serviceprovider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuyf.common.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
