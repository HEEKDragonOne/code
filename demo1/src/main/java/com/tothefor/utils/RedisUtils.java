package com.tothefor.utils;

import redis.clients.jedis.Jedis;

import java.util.Random;

/**
 * @Author DragonOne
 * @Date 2021/11/15 11:13
 */
public class RedisUtils {

    //获取Redis数据库连接
    public static Jedis getRedis() {
        return new Jedis("127.0.0.1", 6379);
    }

    //检验验证码是否
    public static boolean getRcode(String phone, String code) {
        Jedis jedis = RedisUtils.getRedis();
        String codeKey = "Loong:" + phone + ":code";
        String rcode = jedis.get(codeKey);
        jedis.close();
        if (rcode != null) { //判断是否生成了验证码
            if (rcode.equals(code)) {
                System.out.println("登录成功");
                return true;
            } else {
                System.out.println("登录失败");
            }
        } else {
            System.out.println("没有验证码");
        }
//        jedis.close();
        return false;
    }

    //将验证码输入Redis并设置有效时间
    public static String MCode(String phone) {
        Jedis jedis = RedisUtils.getRedis();
        String countKey = "Loong:" + phone + ":count";
        String codeKey = "Loong:" + phone + ":code";
        String count = jedis.get(countKey);
        if (count == null) {
            jedis.setex(countKey, 24 * 60 * 60, "1");
        } else if (Integer.parseInt(count) <= 2) {
            jedis.incr(countKey);
        } else if (Integer.parseInt(count) > 2) {
            System.out.println("今天次数用完了！");
            jedis.close();
            return null;
        }
        String vcode = getCode();
        jedis.setex(codeKey, 120, vcode);
        jedis.close();
        return vcode;
    }

    //获取随机验证码
    public static String getCode() {
        Random random = new Random();
        String code = "";
        for (int i = 0; i < 5; i++) { //控制验证码的长度
            int t = random.nextInt(10);
            code += t;
        }
        return code;
    }
}
