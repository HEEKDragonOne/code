package com.tothefor.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author DragonOne
 * @Date 2021/11/15 14:24
 */

@Getter
@Setter
public class User {
    private String UserName; //用户名
    private String PTID; //平台证号
    private String realName; //真实姓名
    private String UserID; //身份证号
    private String sex; //性别
    private int age; //年龄
    private String tele; //联系方式
    private String address; //联系地址

    public User() {
    }
}
