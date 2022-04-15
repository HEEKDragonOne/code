package com.tothefor.dao;

import com.tothefor.utils.MySQLUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author DragonOne
 * @Date 2021/12/2 19:58
 */
public class CheckUserLife {
    public static boolean CheckUser(String username,String password){
        Connection connection = null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        try {
            connection = MySQLUtils.getConnection();
            String sql ="select * from Users where name=? and pwd=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if (rs.next()){
                String s1 = rs.getString(1);
                String s2 = rs.getString(2);
                System.out.println(s1+" | "+s2+" | ");
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MySQLUtils.closeAll(connection,ps,rs);
        }
        return false;
    }
}
