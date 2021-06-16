package com.example.orderappservice.mapper;

import com.example.orderappservice.pojo.Order;
import com.example.orderappservice.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    @Select("select * from user")
    @Results({
            @Result(property = "user_id", column = "user_id"),
            @Result(property = "addressList", column = "user_id",
        many = @Many(select = "com.example.orderappservice.mapper.AddressMappergetAddressByUserId"))
    })
    List<User> getUserList();

    //查询用户订单总数
    @Select("select user_id,Count(order.order_id) as TotalOrder\n" +
            "from `order`\n" +
            "where user_id=user_id&&order_state=\"ACCEPT\"\n" +
            "group by user_id\n" +
            "order by Count(order.order_id) desc")
    List<Order> getTotalOrderByUserId(Integer user_id);

    //增加用户信息
    @Insert(value = "insert into users VALUES (#{u.user_id},#{u.name}," +
            "#{u.sex},#{u.phone_number},#{u.password})")
    int addUser(@Param("u") User user);

    //删除用户信息
    @Delete("delete from users where user_id=#{user_id}")
    int deleteUser(Integer user_id);
}
