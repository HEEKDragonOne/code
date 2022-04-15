package com.tothefor.servlet;

import com.tothefor.dao.CheckUserLife;
import com.tothefor.utils.MySQLUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author DragonOne
 * @Date 2021/11/15 19:03
 */
@SuppressWarnings("all")
@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //解决输入中文乱码
        resp.setContentType("text/html;charset=UTF-8"); //解决输出中文乱码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username+"  "+password);
        if(CheckUserLife.CheckUser(username,password)){
            req.getRequestDispatcher("/TestGetData.jsp").forward(req,resp);
        }else {
            req.setAttribute("errMsg","请检查用户名和密码是否存在且正确！");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
}
