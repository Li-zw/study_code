package com.lzw.mapper;

import com.lzw.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    //根据用户名和密码获取用户信息
    @Select("select * from login_info where uname=#{uname} and pwd=#{pwd}")
    User selUserInfoMapper(@Param("uname") String uname, @Param("pwd") String pwd);


    @Select("select * from login_info where uid = #{uid}")
    User queryUserIndfoById(@Param("uid") String uid);
}
