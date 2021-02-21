package com.lzw.controller;

import com.lzw.mapper.UserMapper;
import com.lzw.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    //重写service方法
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取请求数据
        String uname=req.getParameter("uname");
        String pwd=req.getParameter("pwd");
        //处理请求
            //获取SqlSession对象
            InputStream is = Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession=factory.openSession();
             //获取Mapper接口对象
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
            //根据用户名和密码获取用户信息
            System.out.println(uname+":"+pwd);
            User user = userMapper.selUserInfoMapper(uname, pwd);
        //响应结果
            if(user!=null){
                resp.getWriter().write("登录成功");
            }else{
                resp.getWriter().write("登录失败");
            }
    }
}
