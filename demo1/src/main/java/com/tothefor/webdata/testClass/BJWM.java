package com.tothefor.webdata.testClass;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @Author DragonOne
 * @Date 2021/12/1 19:36
 */
public class BJWM {
    private static Document doc;

    public static void main(String[] args) {
        try {
            //获取网站链接
            doc = Jsoup.connect("https://beijing.anjuke.com/sale/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 调用Blogs类
        Blogs();
    }

    public static void Blogs() {
        //选择网页中的元素
        Elements tests = doc.select("body");
        //使用for循环遍历网页中的数据
        for (Element test : tests) {
            // 爬取页面中的文章标题
//            String txt = test.select("p.property-content-info-comm-address").first().text();
            String txt = test.select("span").text();
            System.out.println("标题：" + txt);
            // 爬取页面中的文章链接
            String href = test.select("p.property-price-average").text();
            System.out.println("链接：" + href);
            //对爬取的数据进行分割
            System.out.println("---------------------------");
        }
    }
}
