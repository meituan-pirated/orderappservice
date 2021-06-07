package com.example.orderappservice.mapper;

import com.example.orderappservice.pojo.AttributeOption;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AttributeOptionMapper {
    @Select("select * from attribute_option where attribute_id = #{attribute_id}")
    @Result(property = "attribute_option_id",column = "attribute_option_id")
    List<AttributeOption> getAttributeOptionByAttributeId(Integer attribute_id);
}
