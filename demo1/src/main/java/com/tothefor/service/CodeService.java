package com.tothefor.service;

/**
 * @Author DragonOne
 * @Date 2021/11/17 12:32
 */
public interface CodeService {
    public String makeCode(String telephone);
    public boolean checkCode(String telephone,String code);
    public String queryCode(String telephone);
}
