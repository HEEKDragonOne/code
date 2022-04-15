package com.tothefor.utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author DragonOne
 * @Date 2021/11/16 13:08
 */
public class MongoDBUtilsPlus {
    private static MongoClient mongoClient = null;
    private static Properties properties;
    private static InputStream stream = null;
    private static String host;
    private static int port;
    private static String dbName;

    static {
        if (properties == null) {
            properties = new Properties();
        }
        try {
            stream = MongoDBUtilsPlus.class.getClassLoader().getResourceAsStream("mongodb.properties");
            properties.load(stream);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        //获取MongoDB数据库配置数据
        host = properties.getProperty("mongo.host");
        port = Integer.parseInt(properties.getProperty("mongo.port"));
        dbName = properties.getProperty("mongo.dbName");

        if (mongoClient == null) {
            MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
            builder.connectionsPerHost(10);//每个地址的最大连接数
            builder.connectTimeout(5000);//连接超时时间，单位毫秒
            builder.socketTimeout(5000);//设置读写操作超时时间
            ServerAddress address = new ServerAddress(host, port);
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
