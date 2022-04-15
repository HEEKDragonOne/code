package com.tothefor.controller;

import com.google.gson.Gson;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.tothefor.entity.TestGetDataEntity;
import com.tothefor.utils.MongoDBUtils;
import com.tothefor.utils.MongoDBUtilsPlus;
import com.tothefor.webdata.BJdata;
import org.bson.Document;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author DragonOne
 * @Date 2021/11/29 16:09
 */

@WebServlet(value = "/testGet")
public class TestGetDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
        // 先删除集合，再新建集合。已达到删除之前的所有数据目的。
        MongoDatabase db = MongoDBUtils.getMongoDatabase("NoSQL");
        System.out.println(db.getName());
        MongoCollection mc = MongoDBUtils.getCollection("NoSQL","beijing");
        mc.drop();
        db.createCollection("beijing");

            BJdata.getData(); //数据库先获取数据
        } catch (Exception e) {
            e.printStackTrace();
        }

        MongoDatabase md = MongoDBUtilsPlus.getMongoDatabase("NOSQL");
        MongoCollection mc = MongoDBUtilsPlus.getCollection("NoSQL", "beijing");
        final List<TestGetDataEntity> list = new ArrayList<TestGetDataEntity>();
        FindIterable<Document> documents = mc.find();
        documents.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                String name = document.get("title").toString();
                double avg_price =  new Double(document.get("price").toString());
                list.add(new TestGetDataEntity(name, avg_price));
            }
        });

        System.out.println(list.size());
        String json = new Gson().toJson(list);
        System.out.println("testst" + json);
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write(json);
        out.flush();
//        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
