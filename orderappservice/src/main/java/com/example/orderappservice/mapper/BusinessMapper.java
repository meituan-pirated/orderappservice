package com.example.orderappservice.mapper;

import com.example.orderappservice.bean.MBusiness;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BusinessMapper {
    //商家列表
    @Select("select business_id, business_name, refectory, descriptions from business where business_state='on'")
    @Results({
            @Result(property = "business_id", column = "business_id"),
            @Result(property = "totalOrder", column = "business_id",
            one = @One(select = "com.example.orderappservice.mapper.OrderMapper.gerOrderCountByBusinessId"))
    })
    //对business_id赋值
    List<MBusiness> getBusinessList();

    //增加商家信息
    @Insert(value = "insert into business(business_id,business_name,refectory,descriptions,business_state) " +
            "values (#{b.business_id},#{b.businessName},#{b.refectory},#{b.descriptions}, 'on')")
    //设置主键自增
    @Options(useGeneratedKeys = true,keyProperty = "business_id",keyColumn = "business_id")
    int addBusiness(@Param("b") MBusiness mBusiness);

    //根据id查询商家
    @Select("select business_id, business_name, refectory, descriptions, business_state from business " +
            "where business_id=#{business_id}")
    @Results({
            @Result(property = "business_id", column = "business_id"),
            @Result(property = "totalOrder", column = "business_id",
                    one = @One(select = "com.example.orderappservice.mapper.OrderMapper.gerOrderCountByBusinessId"))
    })
    MBusiness getBusinessByBusinessId(Integer business_id);

    //修改商家信息
    @Update("update business set business_name=#{B.businessName}," +
            "refectory=#{B.refectory},descriptions=#{B.descriptions} " +
            "where business_id=#{B.business_id}")
    int updateBusinessByBusinessId(@Param("B") MBusiness mBusiness);

    //停用商家（修改商家的状态为off）
    @Update("update business set business_state='off' where business_id=#{business_id}")
    int updateBusinessStateByBusinessId(@Param("business_id") Integer business_id);


    //查询商家订单总数
    @Select("select business_id,Count(order.order_id) as TotalOrder\n" +
            "from `order`\n" +
            "where business_id=business_id&&order_state=\"ACCEPT\"\n" +
            "group by business_id\n" +
            "order by Count(order.order_id) desc")
    int getOrderNumberByBusinessId(Integer business_id);
//    List<Order> getTotalOrderByBusinessId(Integer business_id);

    //商家数量
    @Select("select count(business_id) as totalOrder from `business`")
    int getBusinessCount();


}
