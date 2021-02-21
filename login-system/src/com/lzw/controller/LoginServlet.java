package com.lzw.controller;

import com.lzw.entity.User;
import com.lzw.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * 功能描述
 *
 * @Author LZW
 * @CreateTime 2021/02/20 15:35
 * @UpdateTime 2021/02/20 15:35
 * @Version 1.0.0
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取请求数据
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();     //uid
                if ("uid".equals(name)) {
                    //根据Cookie中存储的Uid的值获取用户信息并存储到Session中
                    String uid = cookie.getValue();
                    //根据uid获取用户信息
                    InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
                    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
                    SqlSession sqlSession = factory.openSession();
                    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
                    User user = userMapper.queryUserIndfoById(uid);
                    //将User对象存储到Session中
                    HttpSession session = req.getSession();
                    session.setAttribute("user",user);

                    //重定向到主页面
                    resp.sendRedirect(req.getContextPath() + "/main");
                    return;
                }
            }

        }
        //处理请求
        //响应结果
        resp.getWriter().write("<html>");
        resp.getWriter().write("<head>");
        resp.getWriter().write("<body>");
        resp.getWriter().write("<font color='red' size=15>" + (req.getAttribute("flag") == null ? "" : req.getAttribute("flag")) + "</font>");
        resp.getWriter().write("<form action='user' method='post'>");
        resp.getWriter().write("账号:<input type='text' name='uname' value=''><br>");
        resp.getWriter().write("密码:<input type='password' name='pwd' value=''><br>");
        resp.getWriter().write("<input type='submit'  value='Login'>");
        resp.getWriter().write("</form>");
        resp.getWriter().write("</body>");
        resp.getWriter().write("</head>");
        resp.getWriter().write("</html>");

    }
}
