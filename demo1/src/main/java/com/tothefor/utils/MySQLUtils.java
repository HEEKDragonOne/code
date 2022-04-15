package com.tothefor.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Author DragonOne
 * @Date 2021/11/17 18:57
 */
public class MySQLUtils {
    //声明连接池对象
    private static DruidDataSource dds;
    static{
        Properties properties = new Properties();
        InputStream is = MySQLUtils.class.getResourceAsStream("/mysql.properties");
        try {
            properties.load(is);
            //创建连接池
            dds = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return dds.getConnection();//通过连接池获取连接对象
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static DataSource getDataSource(){
        return dds;
    }

    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
