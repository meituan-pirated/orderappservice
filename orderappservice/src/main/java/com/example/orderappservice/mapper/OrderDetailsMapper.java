package com.example.orderappservice.mapper;

import com.example.orderappservice.pojo.OrderDetails;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderDetailsMapper {

    @Select("select * " +
            "from order_details " +
            "where order_id = #{order_id}")
    @Results({
            @Result(property = "order_details_id", column = "order_details_id"),
            @Result(property = "product", column = "product_id",
            many = @Many(select = "com.example.orderappservice.mapper.ProductsMapper.getProductsByProductId"))
//            @Result(property = "orderList", column = "order_id",
//                    many = @Many(select = "com.example.orderappservice.mapper.OrderMapper.getOrderList")),
//            @Result(property = "productList", column = "product_id",
//                    many = @Many(select = "com.example.orderappservice.mapper.ProductsMapper.getProductsByProductId")),
    })
    List<OrderDetails> getOrderDetailsByOrderId(Integer order_id);


}
