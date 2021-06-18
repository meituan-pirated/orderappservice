package com.example.orderappservice.mapper;

import com.example.orderappservice.bean.ProductBriefForM;
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


    @Select("select product_id, product_name, sale_price, image from products where business_id = #{business_id} and product_state = 'on'")
    @Results({
            @Result(property = "product_id", column = "product_id")
    })
    List<ProductBriefForM> getProductBriefForMByBusinessId(Integer business_id);

    @Select("select * from products where product_id = #{product_id}")
    @Results({
            @Result(property = "product_id", column = "product_id")
    })
    Products getProductByProductId(Integer product_id);


    @Insert(value = "INSERT INTO products " +
            "VALUES (#{p.product_id},#{p.business_id},#{p.productName},#{p.descriptions}, #{p.salePrice},#{p.image}, 'on')")
    //设置主键自增
    @Options(useGeneratedKeys = true,keyProperty = "product_id",keyColumn = "product_id")
    int addProduct(@Param("p") Products products);

    @Update({
            "<script> ",
            "update products ",
            "<set> ",
            "<if test = \"p.productName != null and p.productName != '' \"> ",
            "product_name=#{p.productName}, ",
            "</if> ",
            "<if test = \"p.descriptions != null and p.descriptions != ''\"> ",
            "descriptions=#{p.descriptions}, ",
            "</if> ",
            "<if test = \"p.salePrice != null and p.salePrice != ''\"> ",
            "sale_price=#{p.salePrice}, ",
            "</if> ",
            "<if test = \"p.image != null and p.image != ''\"> ",
            "image=#{p.image} ",
            "</if> ",
            "</set> ",
            "where product_id=#{p.product_id}",
            "</script>"
    })
    int saveProductChange(@Param("p") Products products);

    @Update("update products set product_state = 'off' where product_id = #{product_id}")
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
