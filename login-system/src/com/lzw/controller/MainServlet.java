package com.lzw.controller;

import com.lzw.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 功能描述
 *
 * @Author LZW
 * @CreateTime 2021/02/20 16:00
 * @UpdateTime 2021/02/20 16:00
 * @Version 1.0.0
 */

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取请求数据

        //处理请求
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        //响应结果
        resp.getWriter().write("<html>");
        resp.getWriter().write("<head>");
        resp.getWriter().write("<body>");
        resp.getWriter().write("<h3>欢迎" + user.getUname() + "登录成功</h3>");
        resp.getWriter().write("</body>");
        resp.getWriter().write("</head>");
        resp.getWriter().write("</html>");
    }
}
