package com.liuyf.serviceprovider.Service.Impl;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuyf.common.Result;
import com.liuyf.common.Service.UserService;
import com.liuyf.common.entity.User;
import com.liuyf.serviceprovider.mapper.UserMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
@SofaService(interfaceType = UserService.class,uniqueId = "userService",bindings = { @SofaServiceBinding(bindingType = "bolt") })
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Result AddUser(User user){
        // 判断是否有该用户，userid、username唯一
        User ret = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername()));
        if (ret != null){
            return Result.error("-1","用户名重复");
        }
        User userI = User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .phone(user.getPhone())
                .address(user.getPhone())
                .sex(user.getSex())
                .build();
        userMapper.insert(userI);
        return null;
    }

    @Override
    public void DeleteUser(Integer userid){
        userMapper.deleteById(userid);
    }

    @Override
    public void UpdateUser(User user){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("username",user.getUsername());
        updateWrapper.set("password",user.getPassword());
        updateWrapper.set("phone",user.getPhone());
        updateWrapper.set("address",user.getAddress());
        updateWrapper.set("sex",user.getSex());
        userMapper.update(user,updateWrapper);
    }

    @Override
    public List<User> SelectUser(){
        return userMapper.selectList(null);
    }

    @Override
    public User findUserByusername(String username){
        return userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, username));
    };
}
