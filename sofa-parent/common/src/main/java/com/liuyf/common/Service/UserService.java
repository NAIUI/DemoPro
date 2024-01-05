package com.liuyf.common.Service;

import com.liuyf.common.Result;
import com.liuyf.common.entity.User;

import java.util.List;

public interface UserService {


    // 增
    Result AddUser(User user);

    // 删
    void DeleteUser(Integer userid);

    // 改
    void UpdateUser(User user);

    // 查
    List<User> SelectUser();

    User findUserByusername(String username);



}
