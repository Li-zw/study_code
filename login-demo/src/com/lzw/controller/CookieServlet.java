package com.lzw.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 功能描述
 *
 * @Author LZW
 * @CreateTime 2021/02/19 09:41
 * @UpdateTime 2021/02/19 09:41
 * @Version 1.0.0
 */

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("tetx/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        //获取请求数据
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        //处理请求
        System.out.println(uname + "---------" + pwd);
        //响应结果
        /**
         *创建Cookie对象存储要让浏览缓存的数据,一个Cookie对象表明一组键值对
         */
        Cookie cookie = new Cookie("uname", uname);                      //创建cookie对象
        /**
         * 默认将Cookie对象存储再浏览器的内存中,浏览器关闭Cookie数据即销毁
         * 除非设置了Cookie的有效期
         * 设置有效期后Cookie,存储在客户端的硬盘中
         */
        cookie.setMaxAge(3600 * 24 * 3);    //设置Cookie的有效期,以秒为单位
        cookie.setPath("/login_demo/ck");
        /**
         * 被浏览器存储缓存的Cookie信息默认在访问同一个项目的时候会被浏览器以请求数据的方式携带
         */
        resp.addCookie(cookie);             //响应Cookie到浏览器
        resp.getWriter().write("cookie ************");
    }
}
