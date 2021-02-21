package com.lzw.service.impl;

import com.lzw.entity.User;
import com.lzw.mapper.UserMapper;
import com.lzw.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 功能描述
 *
 * @Author LZW
 * @CreateTime 2021/02/20 22:33
 * @UpdateTime 2021/02/20 22:33
 * @Version 1.0.0
 */

public class UserServiceImpl implements UserService {

    @Override
    public User userLoginServlet(String uname, String pwd) throws IOException {
        /**
         * 获取Session对象
         */
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        //查询数据
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selUserInfoMapper(uname, pwd);
        return user;
    }
}
