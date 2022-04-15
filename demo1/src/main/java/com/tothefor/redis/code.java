package com.tothefor.redis;

import redis.clients.jedis.Jedis;

import java.util.Random;

/**
 * @Author DragonOne
 * @Date 2021/10/7 12:10
 */
public class code {
    public static void main(String[] args) {

        /**
         * 先执行生成验证码的代码，再执行进行验证的代码
         */
//        System.out.println(MCode("12345")); //先通过手机号生成验证码
//        System.out.println(getRcode("12345","75919"));  //检验验证码是否正确


    }
    //检验验证码是否
    public static boolean getRcode(String phone,String code){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        String codeKey = "Loong"+phone+":code";
        String rcode = jedis.get(codeKey);
        jedis.close();
        if(rcode!=null){ //判断是否生成了验证码
            if(rcode.equals(code)){
                System.out.println("登录成功");
                return true;
            }else{
                System.out.println("登录失败");
            }
        }else{
            System.out.println("没有验证码");
        }
//        jedis.close();
        return false;
    }
    public static String MCode(String phone){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        String countKey = "Loong" + phone + ":count";
        String codeKey = "Loong" + phone + ":code";
        String count = jedis.get(countKey);
        if(count == null){
            jedis.setex(countKey,24*60*60,"1");
        }else if(Integer.parseInt(count)<=2){
            jedis.incr(countKey);
        }else if(Integer.parseInt(count)>2){
            System.out.println("今天次数用完了！");
            jedis.close();
            return null;
        }
        String vcode = getCode();
        jedis.setex(codeKey,120,vcode);
        jedis.close();
        return vcode;
    }

    public static String getCode(){
        Random random = new Random();
        String code = "";
        for (int i = 0; i < 5; i++) { //控制验证码的长度
            int t = random.nextInt(10);
            code += t;
        }
        return code;
    }
}
