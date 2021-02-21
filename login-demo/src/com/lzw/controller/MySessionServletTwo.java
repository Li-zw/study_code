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
 * @CreateTime 2021/02/20 12:36
 * @UpdateTime 2021/02/20 12:36
 * @Version 1.0.0
 */


@WebServlet("/querySessionTwo")
public class MySessionServletTwo extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println("我被执行了" + user);
        session.invalidate();//销毁Session
    }
}
