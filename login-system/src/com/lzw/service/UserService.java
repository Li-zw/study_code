package com.lzw.service;


import com.lzw.entity.User;

import java.io.IOException;

public interface UserService {
    //用户登录逻辑处理
    User userLoginServlet(String uname, String pwd) throws IOException;
}
