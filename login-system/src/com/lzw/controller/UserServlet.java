package com.lzw.controller;

import com.lzw.entity.User;
import com.lzw.service.UserService;
import com.lzw.service.impl.UserServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 功能描述
 *
 * @Author LZW
 * @CreateTime 2021/02/20 15:48
 * @UpdateTime 2021/02/20 15:48
 * @Version 1.0.0
 */


@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取请求数据
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        //处理请求
        UserService userService = new UserServiceImpl();
        User user = userService.userLoginServlet(uname, pwd);

        //响应结果
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            //创建登录成功的Cookie信息
            Cookie cookie = new Cookie("uid", user.getUid() + "");
            cookie.setMaxAge(3600 * 24 * 3);
            resp.addCookie(cookie);
            //重定向到打印主页面的Servlet中
            resp.sendRedirect(req.getContextPath() + "/main");
        } else {
            req.setAttribute("flag", "用户名或者密码错误");
            req.getRequestDispatcher("/login").forward(req, resp);
        }

    }
}
