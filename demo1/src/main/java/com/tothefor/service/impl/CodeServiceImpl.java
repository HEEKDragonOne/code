package com.tothefor.service.impl;

import com.tothefor.service.CodeService;
import redis.clients.jedis.Jedis;

import static com.tothefor.redis.code.MCode;
import static com.tothefor.redis.code.getRcode;

/**
 * @Author DragonOne
 * @Date 2021/11/17 12:33
 */
public class CodeServiceImpl implements CodeService {
    @Override
    public String makeCode(String telephone) {
        String code = MCode(telephone);
        return code;
    }

    @Override
    public boolean checkCode(String telephone, String code) {
        return getRcode(telephone,code);
    }

    @Override
    public String queryCode(String telephone) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        String codeKey = "Loong"+telephone+":code";
        String rcode = jedis.get(codeKey);
        return rcode;
    }
}
