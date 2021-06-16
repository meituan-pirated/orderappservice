package com.example.orderappservice.mapper;

import com.example.orderappservice.pojo.Business;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BusinessMapper {
    //查询商家
    @Select("select * from business")
    @Results({
            @Result(property = "business_id", column = "business_id"),
//            @Result(property = "businessName", column = "business_name"),
//            @Result(property = "refectory", column = "refectory"),
//            @Result(property = "description", column = "descriptions"),
//            @Result(property = "businessImage", column = "business_image"),
            @Result(property = "productsList", column = "business_id",
            many = @Many(select = "com.example.orderappservice.mapper.ProductsMapper.getProductsByBusinessId"))
    })
    //对business_id赋值
    List<Business> getBusinessList();

    @Select("select * from business where business_id = #{business_id}")
    Business getBusinessByBusinessId(Integer business_id);
//
//    //根据id查询商家
//    //查询商家
//    @Select("select * from business")
//    @Results({
//            @Result(property = "businessName", column = "business_name"),
//            @Result(property = "refectory", column = "refectory"),
//            @Result(property = "description", column = "descriptions"),
//            @Result(property = "businessImage", column = "business_image"),
//            @Result(property = "productsSet", column = "business_id",
//                    many = @Many(select = "com.example.orderappservice.mapper.ProductsMapper.getProductsById"))
//    })
//    //对business_id赋值
//    @Result(property = "business_id", column = "business_id")
//    List<Business> getBusinessByBusinessId(Integer business_id);


}
