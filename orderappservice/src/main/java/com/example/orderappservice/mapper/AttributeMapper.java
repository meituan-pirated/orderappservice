package com.example.orderappservice.mapper;

import com.example.orderappservice.pojo.Attribute;
import com.github.pagehelper.ISelect;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AttributeMapper {
    @Select("select * from attribute where product_id = #{product_id}")
    @Results({
        @Result(property = "attributeOptionList", column = "attribute_id",
        many = @Many(select = "com.example.orderappservice.mapper.AttributeOptionMapper.getAttributeOptionByAttributeId"))
    })
    @Result(property = "attribute_id", column = "attribute_id")
    List<Attribute> getAttributesByProductId(Integer product_id);
}
