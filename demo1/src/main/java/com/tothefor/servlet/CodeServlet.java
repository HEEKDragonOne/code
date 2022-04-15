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
 * @Date 2021/11/17 12:27
 */
@WebServlet(name = "CodeServlet",value = "/code")
@SuppressWarnings("all")
public class CodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //解决输入中文乱码
        resp.setContentType("text/html;charset=UTF-8"); //解决输出中文乱码
        String tele = req.getParameter("phone");
        String code =req.getParameter("code");
        if(RedisUtils.getRcode(tele,code)){
            req.getRequestDispatcher("/TestGetData.jsp").forward(req,resp);
        }else {
            req.setAttribute("errMsg","您的验证码不正确或已过期！请检查您的信息是否填写正确。");
        }

//        String userCode = RedisUtils.MCode(tele);
//        req.setAttribute("code",userCode);
        req.getRequestDispatcher("/static/jsp/getCode.jsp").forward(req,resp);
        System.out.println(tele);

    }
}
