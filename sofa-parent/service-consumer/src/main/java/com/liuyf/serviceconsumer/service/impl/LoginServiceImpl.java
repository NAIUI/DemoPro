package com.liuyf.serviceconsumer.service.impl;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.liuyf.common.Result;
import com.liuyf.common.Service.LoginService;
import com.liuyf.common.Service.UserService;
import com.liuyf.common.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class LoginServiceImpl implements LoginService {
    @SofaReference(binding = @SofaReferenceBinding(bindingType = "bolt"), uniqueId = "userService")
    private UserService userService;

    @Override
    public Object login(String username, String password){
        if (!username.isEmpty() && !password.isEmpty()){
            // 判断存在用户
            User user = userService.findUserByusername(username);
            if (user == null){
                return Result.error("-1","用户不存在");
            }
            // 密码判断
            if(user.getPassword().equals(password)){
                return Result.success(user);
            }else return Result.error("-1","密码错误");
        }else return Result.error("-1","用户名或密码为空");

    }

}
