package com.example.service;

public interface VerifyService {

    public void sendVerifyCode(String mail);

    boolean doVerify(String mail, String code);
}
