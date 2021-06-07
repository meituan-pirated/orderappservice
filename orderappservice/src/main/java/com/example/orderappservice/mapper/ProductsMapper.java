package com.example.orderappservice.mapper;

import com.example.orderappservice.pojo.Products;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductsMapper {

    @Select("select * from products where business_id = #{business_id}")
    //结果集
    @Results({
            @Result(property = "product_id", column = "product_id"),
//            @Result(property = "productName", column = "product_name"),
//            @Result(property = "description", column = "descriptions"),
//            @Result(property = "salePrice", column = "sale_price"),
//            @Result(property = "deliveryPrice", column = "delivery_price"),
//            @Result(property = "image", column = "image"),
            @Result(property = "attributeList", column = "product_id",
            many = @Many(select = "com.example.orderappservice.mapper.AttributeMapper.getAttributesByProductId"))
    })
//    @Result(property = "product_id", column = "product_id")
    List<Products> getProductsByBusinessId(Integer business_id);


    @Select("select * from products where product_id = #{product_id}")
    //结果集
    @Results({
            @Result(property = "product_id", column = "product_id"),
//            @Result(property = "productName", column = "product_name"),
//            @Result(property = "description", column = "description"),
//            @Result(property = "salePrice", column = "sale_price"),
//            @Result(property = "deliveryPrice", column = "delivery_price"),
//            @Result(property = "image", column = "image"),

    })
    List<Products> getProductsByProductId(Integer product_id);

    @Insert(value = "INSERT INTO products " +
            "VALUES (#{p.product_id},#{p.business.business_id},#{p.productName},#{p.descriptions}, #{p.salePrice},#{p.deliveryPrice},#{p.image})")
    //设置主键自增
    @Options(useGeneratedKeys = true,keyProperty = "product_id",keyColumn = "product_id")
    int addProduct(@Param("p") Products products);

    @Delete("delete from products where product_id = #{product_id}")
    int deleteProduct(Integer product_id);
//
//    @Select("select * from products")
//    @Results({
//            @Result(property = "productName", column = "product_name"),
//            @Result(property = "description", column = "description"),
//            @Result(property = "salePrice", column = "sale_price"),
//            @Result(property = "deliveryPrice", column = "delivery_price"),
//            @Result(property = "image", column = "image")
//    })
//    List<Products> getProductsList();
}
