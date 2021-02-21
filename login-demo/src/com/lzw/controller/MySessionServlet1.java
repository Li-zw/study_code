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
 * @CreateTime 2021/02/20 10:24
 * @UpdateTime 2021/02/20 10:24
 * @Version 1.0.0
 */

@WebServlet("/querySessionOne")
public class MySessionServlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("tetx/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        //获取请求数据
        //获取Cookie信息
        User user = new User(1, "xx", "15312345678", "女");
        HttpSession session = req.getSession();
        session.setAttribute("user",user);
        System.out.println(session.getId());


        resp.getWriter().write("this is a session");
        System.out.println("this is a session");
        //处理请求
        //响应结果
    }
}
