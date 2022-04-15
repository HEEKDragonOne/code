package com.tothefor.controller;

/**
 * @Author DragonOne
 * @Date 2021/11/15 10:52
 */
public interface LoginCheckController {
    //检测用户名
    public boolean checkUserName();
    //检测密码
    public boolean checkUserPassword();
    //检测验证码
    public boolean checkCode();
}
