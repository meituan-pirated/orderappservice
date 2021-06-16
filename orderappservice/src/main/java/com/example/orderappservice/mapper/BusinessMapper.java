package com.example.orderappservice.mapper;

import com.example.orderappservice.pojo.Business;
import com.example.orderappservice.pojo.BusinessForR;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BusinessMapper {
    //查询商家
    @Select("select * from business")
    @Results({
//            @Result(property = "businessName", column = "business_name"),
//            @Result(property = "refectory", column = "refectory"),
//            @Result(property = "description", column = "descriptions"),
//            @Result(property = "businessImage", column = "business_image"),
            @Result(property = "productsList", column = "business_id",
            many = @Many(select = "com.example.orderappservice.mapper.ProductsMapper.getProductsByBusinessId"))
    })
    //对business_id赋值
    @Result(property = "business_id", column = "business_id")
    List<Business> getBusinessList();


    //根据id查询商家
    //查询商家
    @Select("select * from business where business_id = #{business_id}")
    @Results({
            @Result(property = "business_id", column = "business_id"),
            @Result(property = "businessName", column = "business_name"),
            @Result(property = "refectory", column = "refectory"),
            @Result(property = "descriptions", column = "descriptions"),
            @Result(property = "businessImage", column = "business_image"),
            @Result(property = "productsList", column = "business_id",
                    many = @Many(select = "com.example.orderappservice.mapper.ProductsMapper.getProductsByBusinessId"))
    })
    //对business_id赋值

    Business getBusinessByBusinessId(Integer business_id);



    @Select("select * from business where business_id = #{business_id}")
    @Results({
            @Result(property = "business_id", column = "business_id"),
            @Result(property = "businessName", column = "business_name"),
            @Result(property = "refectory", column = "refectory"),
    })
    Business getBusinessForRById(Integer business_id);

    @Select("select business_id,business_name,refectory from business where business_id = #{business_id}")
    @Results({
            @Result(property = "business_id", column = "business_id"),
            @Result(property = "businessName", column = "business_name"),
            @Result(property = "refectory", column = "refectory"),
    })
    BusinessForR getBusinessForR(Integer business_id);


}
