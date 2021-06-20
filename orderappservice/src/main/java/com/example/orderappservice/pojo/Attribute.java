package com.example.orderappservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attribute {
    private Integer attribute_id;
    private String attributeName;

//    //一个属性只属于一个商品
//    private Products products;

    //一个属性有多个可以选择的值,属性是一的一方
    private List<AttributeOption> attributeOptionList;


}
