package com.example.orderappservice.mapper;

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
}
