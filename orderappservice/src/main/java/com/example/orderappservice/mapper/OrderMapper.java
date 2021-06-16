package com.example.orderappservice.mapper;

import com.example.orderappservice.bean.OrderDoneBriefForM;
import com.example.orderappservice.bean.OrderDoneInfoForM;
import com.example.orderappservice.bean.OrderIngForM;
import com.example.orderappservice.pojo.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {
    @Select("select * from `order` where order_id = #{order_id}")
    @Results({
            @Result(property = "order_id",column = "order_id"),
            @Result(property = "address", column = "address_id",
            many = @Many(select = "com.example.orderappservice.mapper.AddressMapper.getAddressByAddressId")),
            @Result(property = "orderDetailsList", column = "order_id",
                    many = @Many(select = "com.example.orderappservice.mapper.OrderDetailsMapper.getOrderDetailsByOrderId"))
    })
    Order getOrderByOrderId(Integer order_id);



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


    @Select("select order_id, order_note, order_state, rider_id, order_id, order_time from `order` where business_id = #{business_id} and order_state = #{order_state}")
    @Results({
            @Result(property = "order_id", column = "order_id"),
            @Result(property = "orderNote", column = "order_note"),
            @Result(property = "orderState", column = "order_state"),
            @Result(property = "rider", column = "rider_id",
                    many = @Many(select = "com.example.orderappservice.mapper.RiderMapper.getRiderForMByRiderId")),
            @Result(property = "orderDetailsList", column = "order_id",
                    many = @Many(select = "com.example.orderappservice.mapper.OrderDetailsMapper.getOrderDetailsByOrderId")),
//            @Result(property = "orderPrice", column = "order_price"),
            @Result(property = "orderTime", column = "order_time")
    })
    List<OrderIngForM> getOrderIngByBusinessId(@Param("business_id") Integer business_id, @Param("order_state") String order_state);


    @Select("select order_id, user_id, business_id, order_state, order_price, total_amount, business_score from `order` where business_id = #{business_id} and order_state = #{order_state}")
    @Results({
            @Result(property = "order_id", column = "order_id"),
            @Result(property = "user_id", column = "user_id"),
            @Result(property = "orderState", column = "order_state"),
            @Result(property = "orderDetailsList", column = "order_id",
                    many = @Many(select = "com.example.orderappservice.mapper.OrderDetailsMapper.getOrderDetailsByOrderId")),
            @Result(property = "orderPrice", column = "order_price"),
            @Result(property = "totalAmount", column = "total_amount"),
            @Result(property = "businessScore", column = "business_score"),

    })
    List<OrderDoneBriefForM> getOrderDoneByBusinessId(@Param("business_id") Integer business_id, @Param("order_state") String order_state);

    @Select("select order_id, order_time, arrive_time,rider_id from `order` where order_id = ${order_id}")
    @Results({
            @Result(property = "order_id", column = "order_id"),
            @Result(property = "orderDetailsList", column = "order_id",
                    many = @Many(select = "com.example.orderappservice.mapper.OrderDetailsMapper.getOrderDetailsByOrderId")),
            @Result(property = "rider", column = "rider_id",
                    many = @Many(select = "com.example.orderappservice.mapper.RiderMapper.getRiderByRiderId"))
    })
    OrderDoneInfoForM getOrderDoneInfoForMByOrderId(Integer order_id);

    @Update("update `order` set order_state= #{order_state} where order_id = #{order_id}")
    int updateOrderStateByOrderId(@Param("order_state") String order_state, @Param("order_id") Integer order_id);

}
