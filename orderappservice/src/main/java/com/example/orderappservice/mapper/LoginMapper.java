package com.example.orderappservice.mapper;

import com.example.orderappservice.bean.RestFulBean;
import com.example.orderappservice.pojo.Login;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LoginMapper {

    @Select("select * from login where user_id = #{user_id}")
    @Results({
            @Result(property = "user_id", column = "user_id"),
            @Result(property = "user_type", column = "user_type"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "password", column = "password"),
    })
    Login getLoginById(Integer user_id);

    @Select("select * from login where phone = #{phone}")
    @Results({
            @Result(property = "user_id", column = "user_id"),
            @Result(property = "user_type", column = "user_type"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "password", column = "password")

    })
    Login getLoginByPhone(@Param("phone") String phone);


    @Update("update `login` set password = #{password} where user_id = #{user_id}")
    int updateLoginById(@Param("password") String password,@Param("user_id") Integer user_id);




}
