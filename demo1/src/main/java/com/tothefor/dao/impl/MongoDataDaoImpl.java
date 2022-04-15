package com.tothefor.dao.impl;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.tothefor.dao.MongoDataDao;

/**
 * @Author DragonOne
 * @Date 2021/11/15 11:11
 */
public class MongoDataDaoImpl implements MongoDataDao {
    @Override
    public MongoDatabase getMongoDatabase(String dbName) {
        return null;
    }

    @Override
    public MongoCollection getCollection(String dbName, String collectionName) {
        return null;
    }
}
