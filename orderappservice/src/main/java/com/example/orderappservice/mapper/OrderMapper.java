package com.example.orderappservice.mapper;

import com.example.orderappservice.pojo.Order;
import com.example.orderappservice.pojo.OrderDetails;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {

    @Select("select count(order_id) as totalOrder from `order` where business_id = #{business_id}")
    int gerOrderCountByBusinessId(Integer business_id);

    @Select("select count(order_id) as totalOrder from `order` where user_id = #{user_id}")
    int getOrderCountByUserId(Integer user_id);

    @Select("select count(order_id) as totalOrder from `order` where rider_id = #{rider_id}")
    int getOrderCountByRiderId(Integer rider_id);

    @Select("select count(order_id) as totalOrder from `order`")
    int getOrderCount();

    @Select("select * from `order` where order_id = #{order_id}")
    @Results({
            @Result(property = "order_id",column = "order_id"),
            @Result(property = "address", column = "address_id",
            many = @Many(select = "com.example.orderappservice.mapper.AddressMapper.getAddressByAddressId")),
            @Result(property = "orderDetailsList", column = "order_id",
                    many = @Many(select = "com.example.orderappservice.mapper.OrderDetailsMapper.getOrderDetailsByOrderId"))
    })
    List<Order> getOrderByOrderId(Integer order_id);

//    @Select("select * from `order`")
//    @Results({
//            @Result(property = "order_id",column = "order_id"),
//            @Result(property = "user_id", column = "user_id"),
//            @Result(property = "orderDetailsList", column = "order_id",
//            many = @Many(select = "com.example.orderappservice.mapper.OrderDetailsMapper.getOrderDetailsByOrderId"))
//    })
//    List<Order> getOrderList();

    @Select("select * from `order` where business_id = #{business_id} and order_state = #{order_state}")
    @Results({
            @Result(property = "order_id",column = "order_id"),
            @Result(property = "user_id", column = "user_id"),
            @Result(property = "business_id", column = "business_id"),
            @Result(property = "rider_id", column = "rider_id"),
            @Result(property = "address", column = "address_id",
                    many = @Many(select = "com.example.orderappservice.mapper.AddressMapper.getAddressByAddressId")),
            @Result(property = "orderDetailsList", column = "order_id",
                    many = @Many(select = "com.example.orderappservice.mapper.OrderDetailsMapper.getOrderDetailsByOrderId"))
    })
    List<Order> getOrderByOrderState(@Param("business_id") Integer business_id, @Param("order_state") String order_state);

    @Update("update `order` set order_state= #{order_state} where order_id = #{order_id}")
    int updateOrderStateByOrderId(@Param("order_state") String order_state,@Param("order_id") Integer order_id);

//    //修改订单状态
//    @Update("update 'order' set order_state='off' where user_id=#{user_id}")
//    int updateOrderStateByUserId(@Param("user_id") Integer user_id);
}
