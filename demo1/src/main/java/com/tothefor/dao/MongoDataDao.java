package com.tothefor.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * @Author DragonOne
 * @Date 2021/11/15 11:08
 */
public interface MongoDataDao {
    //MongoDB通过数据库名，获取数据库
    public MongoDatabase getMongoDatabase(String dbName);
    //MongoDB通过数据库名和集合名，获取集合
    public MongoCollection getCollection(String dbName, String collectionName);
    //MongoDB通过数据库名称和集合名称，向指定集合中插入数据

    //MongoDB通过数据库名称和集合名称、用户名和密码检验

}
