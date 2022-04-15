package com.tothefor.servlet;

import com.tothefor.utils.RedisUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author DragonOne
 * @Date 2021/11/15 19:30
 */
@WebServlet(name = "registerServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //解决输入中文乱码
        resp.setContentType("text/html;charset=UTF-8"); //解决输出中文乱码
        String tele = req.getParameter("telephone");
        String userCode = RedisUtils.MCode(tele);
        String rusercode = "您的验证码为："+userCode;
        req.setAttribute("code",rusercode);
        req.getRequestDispatcher("/static/jsp/getCode.jsp").forward(req,resp);
        System.out.println(userCode);
        System.out.println(tele);

    }
}
