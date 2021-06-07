package com.example.orderappservice.mapper;

import com.example.orderappservice.pojo.Address;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AddressMapper {
    @Select("select * from address where user_id = #{user_id}")
    @Result(property = "address_id", column = "address_id")
    List<Address> getAddressByUserId(Integer user_id);

    @Select("select * from address where address_id = #{address_id}")
    @Results(
        @Result(property = "address_id", column = "address_id")
    )
    Address getAddressByAddressId(@Param("address_id") Integer address_id);
}
