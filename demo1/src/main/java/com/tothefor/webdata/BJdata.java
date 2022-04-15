package com.tothefor.webdata;

import com.tothefor.entity.TestGetDataEntity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.*;

/**
 * @Author DragonOne
 * @Date 2021/12/1 19:25
 */
@SuppressWarnings("all")
public class BJdata {
    public static void main(String[] args)  throws Exception{
        System.out.println("获取数据");
        getData();
    }
    public static void getData() throws Exception{
        List<TestGetDataEntity> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        String url = "https://beijing.anjuke.com/sale/";
        Document document = Jsoup.parse(new URL(url),13000);
        Elements elements = document.getElementsByClass("list-left");
        Elements elements1 = elements.first().getElementsByClass("list");
        Elements ele = elements1.select("div.property");
//        System.out.println(ele.html());
//        System.out.println("============================================================");
        for(Element el : ele){
            TestGetDataEntity tge = new TestGetDataEntity();
            System.out.println("------------------------------------------");
            String title = el.select("p.property-content-info-comm-address>span").eq(0).text();
            tge.setName(title);
            set.add(title);
            System.out.println(title); //测试输出
            String link = el.getElementsByClass("property-price-average").text();
            System.out.println(link); //测试输出
            link = link.substring(0,link.indexOf("元/")); //数据截断处理
            tge.setPrice(Double.parseDouble(link));
            System.out.println(link); //测试输出
            list.add(tge);
        }
        System.out.println(list.size()); //测试输出
        ourDataSpark.DataFX(list,set); //进行数据处理
    }
}
