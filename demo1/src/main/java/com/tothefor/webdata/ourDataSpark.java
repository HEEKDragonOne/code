package com.tothefor.webdata;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.tothefor.entity.TestGetDataEntity;
import com.tothefor.utils.MongoDBUtilsPlus;
import org.bson.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Author DragonOne
 * @Date 2021/12/2 13:46
 */
public class ourDataSpark {
    public static void DataFX(List<TestGetDataEntity> list, Set<String> set) {
        List<TestGetDataEntity> users = new ArrayList<>();
        System.out.println("成功进入");
        for (String ind : set) {
            String s = ind;
            double ans = 0;
            int cnt = 0;
            for (TestGetDataEntity tge : list) {
                TestGetDataEntity mid = tge;
                if (mid.getName().equals(s)) {
                    cnt++;
                    ans += mid.getPrice();
                }
            }
            ans /= cnt;
            //小数位数保留2位 四舍五入
            BigDecimal b = new BigDecimal(ans);
            double ans1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            TestGetDataEntity tq = new TestGetDataEntity();
            tq.setName(s);
            tq.setPrice(ans1);
            users.add(tq);
        }
        System.out.println("处理结果为：" + users.size());
        for (TestGetDataEntity s : users) {
            MongoDatabase md = MongoDBUtilsPlus.getMongoDatabase("NoSQL");
            MongoCollection mc = MongoDBUtilsPlus.getCollection("NoSQL", "beijing");
            Document document = new Document("title", s.getName()).append("price", s.getPrice());
            mc.insertOne(document);
            System.out.println(mc.getNamespace());
            System.out.println(s.getName() + " : " + s.getPrice());
        }
    }
}
