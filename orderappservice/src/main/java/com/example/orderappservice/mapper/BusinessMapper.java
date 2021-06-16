package com.example.orderappservice.mapper;

import com.example.orderappservice.pojo.Business;
import com.example.orderappservice.pojo.Order;
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


    //商家列表
    @Select("select * from ")

    //查询商家订单总数
    @Select("select business_id,Count(order.order_id) as TotalOrder\n" +
            "from `order`\n" +
            "where business_id=business_id&&order_state=\"ACCEPT\"\n" +
            "group by business_id\n" +
            "order by Count(order.order_id) desc")
    List<Order> getTotalOrderByBusinessId(Integer business_id);

    //增加商家信息
    @Insert(value = "INSERT INTO business" +
            "VALUES (#{b.business_id},#{b.business_name},#{b.refectory},#{b.descriptions})")
    int addBusiness(@Param("b") Business business);

    //更新商家信息
    @Update("update 'business' set " +
            "business_id=#{b1.business_id},business_name=#{b1.business_name},refectory=#{b1.refectory},descriptions=#{b1.descriptions} " +
            "where business_id=#{business_id}")
    int updateBusinessByBusinessId(@Param("b1") Business business);

    //删除商家信息
    @Delete("delete from products where business_id = #{business_id}")
    int deleteBusiness(Integer business_id);

}
