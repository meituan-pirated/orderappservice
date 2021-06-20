package com.example.orderappservice.mapper;

import com.example.orderappservice.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
//    //用户列表
//    @Select("select user_id,name,sex,phone_number,password from users where user_state='on'")
//    @Results({
//            @Result(property = "user_id",column = "user_id"),
//            @Result(property = "totalOrder",column = "user_id",
//                    one = @One(select = "com.example.orderappservice.mapper.OrderMapper.getOrderCountByUserId"))
//    })
//    List<MUser> getUserList();

    //添加用户信息
    @Insert(value="insert into users(user_id,name,sex,phone_number,password,user_state) " +
            "values (#{u.user_id},#{u.name},#{u.sex},#{u.phoneNumber},#{u.password},'on')")
    //设置主键自增
    @Options(useGeneratedKeys = true,keyProperty = "user_id",keyColumn = "user_id")
    int addUser(@Param("u") MUser mUser);



    @Select("select * from user")
    @Results({
            @Result(property = "user_id", column = "user_id"),
            @Result(property = "addressList", column = "user_id",
        many = @Many(select = "com.example.orderappservice.mapper.AddressMappergetAddressByUserId"))
    })
    List<User> getUserList();

    //删除用户
    @Update("update users set user_state='off' where user_id=#{user_id}")
    int updateUserStateByUserId(@Param("user_id") Integer user_id);

    //用户数量
    @Select("select count(user_id) as totalOrder from `users`")
    int getUserCount();
}
