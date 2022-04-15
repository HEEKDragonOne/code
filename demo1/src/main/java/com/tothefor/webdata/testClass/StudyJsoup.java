package com.tothefor.webdata.testClass;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;

/**
 * @Author DragonOne
 * @Date 2021/12/1 06:51
 */
public class StudyJsoup {
    public static void main(String[] args) throws Exception {
        String url = "https://www.cnblogs.com/";
        Document document = Jsoup.parse(new URL(url),13000);
        //获取元素标签 内的 所有内容（不包括获取标签）,用法同JS中一样
        Element element = document.getElementById("__layout");
        //打印元素标签 内的 所有内容（不包括获取标签）
//        System.out.println(element.html());
        System.out.println("============================================================");
        //获取所有article标签
        Elements elements = element.getElementsByTag("a");
        for(Element el : elements){
            System.out.println("------------------------------------------");
            String title = el.getElementsByClass("post-item-title").eq(0).text();
            System.out.println(title);
            String link = el.getElementsByClass("post-item-title").eq(0).attr("href");
            System.out.println(link);
        }

    }
}
