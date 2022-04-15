package com.tothefor.utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * @Author DragonOne
 * @Date 2021/11/15 09:48
 */
public class MongoDBUtils {
    private static MongoClient mongoClient = null;

    //连接到 mongodb 服务
    static {
        if (mongoClient == null) {
            MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
            builder.connectionsPerHost(10);//每个地址的最大连接数
            builder.connectTimeout(5000);//连接超时时间，单位毫秒
            builder.socketTimeout(5000);//设置读写操作超时时间
            ServerAddress address = new ServerAddress("localhost", 27017);
            mongoClient = new MongoClient(address, builder.build());
        }
    }

    //连接到数据库
    public static MongoDatabase getMongoDatabase(String dbName) {
        return mongoClient.getDatabase(dbName);
    }

    //获取集合
    public static MongoCollection getCollection(String dbName, String collectionName) {
        MongoDatabase dbs = getMongoDatabase(dbName);
        return dbs.getCollection(collectionName);
    }
}
