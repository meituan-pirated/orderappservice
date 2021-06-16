package com.example.orderappservice.mapper;

import com.example.orderappservice.pojo.Order;
import com.example.orderappservice.pojo.OrderDetailsForR;
import com.example.orderappservice.pojo.OrderForR;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {
    @Select("select * from `order` where order_id = #{order_id}")
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

    @Select("select * from `order` where order_state = 'maccept'")
    @Results({
            @Result(property = "order_id",column = "order_id"),
            @Result(property = "order_state",column = "order_state"),
            @Result(property = "arrive_time",column = "arrive_time"),
            @Result(property = "rider_score",column = "rider_score"),
            @Result(property = "businessInfo", column = "business_id",
                    many = @Many(select = "com.example.orderappservice.mapper.BusinessMapper.getBusinessForR")),
            @Result(property = "address", column = "address_id",
                    many = @Many(select = "com.example.orderappservice.mapper.AddressMapper.getAddressByAddressId")),

    })
    List<OrderForR> getNewOrderList();

    @Select("select order_id,  order_state, address_id, business_id from `order` where (order_state = 'raccept' or order_state = 'at_res' or order_state = 'raccept') " +
            "and rider_id = #{rider_id}")
    @Results({
            @Result(property = "order_id",column = "order_id"),
            @Result(property = "order_state",column = "order_state"),
            @Result(property = "arrive_time",column = "arrive_time"),
            @Result(property = "rider_score",column = "rider_score"),
            @Result(property = "businessInfo", column = "business_id",
                    many = @Many(select = "com.example.orderappservice.mapper.BusinessMapper.getBusinessForR")),
            @Result(property = "address", column = "address_id",
                    many = @Many(select = "com.example.orderappservice.mapper.AddressMapper.getAddressByAddressId")),

    })
    List<OrderForR> getUnderwayOrderList(@Param("rider_id")Integer rider_id);


    @Select("select order_id,  order_state, address_id, business_id,arrive_time,rider_score from `order` where order_state = 'arrive'"+
            "and rider_id = #{rider_id}")
    @Results({
            @Result(property = "order_id",column = "order_id"),
            @Result(property = "order_state",column = "order_state"),
            @Result(property = "arrive_time",column = "arrive_time"),
            @Result(property = "rider_score",column = "rider_score"),
            @Result(property = "businessInfo", column = "business_id",
                    many = @Many(select = "com.example.orderappservice.mapper.BusinessMapper.getBusinessForR")),
            @Result(property = "address", column = "address_id",
                    many = @Many(select = "com.example.orderappservice.mapper.AddressMapper.getAddressByAddressId")),

    })
    List<OrderForR> getFinishedOrderForR(@Param("rider_id")Integer rider_id);


    @Update("update `order` set rider_id= #{rider_id} where order_id = #{order_id}")
    int updateOrderRider(@Param("order_id") Integer order_id,@Param("rider_id")Integer rider_id);

    @Update("update `order` set arrive_time = #{time} where order_id = #{order_id}")
    int markOrderArrive(@Param("order_id") Integer order_id,@Param("time")String time);

    @Select("select * from `order` where order_id = #{order_id}")
    @Results({

            @Result(property = "businessInfo", column = "business_id",
                    many = @Many(select = "com.example.orderappservice.mapper.BusinessMapper.getBusinessForR")),
            @Result(property = "order",column = "order_id",
                    many = @Many(select = "com.example.orderappservice.mapper.OrderMapper.getOrderByOrderId"))

    })
    OrderDetailsForR getOrderDetailsForRByOrderId(Integer order_id);

    @Select("select count(order_id) from `order` where order_time >= #{today}")
    Integer getTodayOrderByRiderId(String today);



}
