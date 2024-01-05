package com.liuyf.serviceconsumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.liuyf.common.Result;
import com.liuyf.common.Service.UserService;
import com.liuyf.common.entity.User;
import com.liuyf.serviceconsumer.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @SofaReference(binding = @SofaReferenceBinding(bindingType = "bolt"),uniqueId = "userService")
    private UserService userService;

    @Autowired
    private LoginServiceImpl loginService;

    @PostMapping("/register")
    public Result register(@RequestBody User user){
        return userService.AddUser(user);
    }

    @PostMapping("/login")
    public Result<?> login(@RequestBody JSONObject parmsInfo){
        String username = parmsInfo.getString("username");
        String password = parmsInfo.getString("password");
        return (Result<?>) loginService.login(username,password);
    }

    @GetMapping("/findAllUsers")
    public Result<?> findAllUsers(){
        return  Result.success(userService.SelectUser());
    }

}

