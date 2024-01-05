package book.manager.service;

import book.manager.entity.AuthUser;

import javax.servlet.http.HttpSession;

public interface AuthService {

    void register(String name,String sex,String grade,String password);

    public AuthUser findUser(HttpSession session);
}
