package book.manager.service.impl;

import book.manager.entity.AuthUser;
import book.manager.mapper.UserMapper;
import book.manager.service.AuthService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    UserMapper userMapper;

    @Override
    @Transactional
    public void register(String name, String sex, String grade, String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        AuthUser authUser = new AuthUser(0,name,encoder.encode(password),"user");
        if (userMapper.registerUser(authUser) <= 0)
            throw new RuntimeException("用户基本信息添加失败！");
        if (userMapper.addStudentInfo(authUser.getId(),name,grade,sex) <= 0)
            throw new RuntimeException("学生详细信息插入失败！");
    }

    @Override
    public AuthUser findUser(HttpSession session) {
        AuthUser user = (AuthUser) session.getAttribute("user");
        if(user == null){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            user = userMapper.getPasswordByUsername(authentication.getName());
            session.setAttribute("user",user);
        }
        return user;
    }
}
