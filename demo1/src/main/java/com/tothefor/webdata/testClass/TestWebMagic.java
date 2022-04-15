package com.tothefor.webdata.testClass;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @Author DragonOne
 * @Date 2021/11/30 18:16
 */
public class TestWebMagic {
    private static Document doc;

    public static void main(String[] args) {
        try {
            //获取网站链接
            doc = Jsoup.connect("https://www.cnblogs.com/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 调用Blogs类
        Blogs();
    }

    public static void Blogs() {
        //选择网页中的元素
        Elements tests = doc.select("div#post_list>article.post-item");
        System.out.println(tests.html());
        //使用for循环遍历网页中的数据
//        for (Element test : tests) {
//            //爬取页面中的文章标题
//            String txt = test.select("section.post-item-body>div.post-item-text>a.post-item-title").text();
//            System.out.println("标题：" + txt);
//            //爬取页面中的文章链接
//            String href = test.select("section.post-item-body>div.post-item-text>p.post-item-summary>a").attr("href");
//            System.out.println("链接：" + href);
//            //对爬取的数据进行分割
//            System.out.println("---------------------------");
//        }
    }
}
