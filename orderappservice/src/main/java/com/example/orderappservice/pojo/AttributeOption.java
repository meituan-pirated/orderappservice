package com.example.orderappservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttributeOption {
    private Integer attribute_option_id;
    private String optionName;

//    //一个属性值属于一个属性
//    private Attribute attribute;
//
//    //属于多的一方
//    private AttributeList attributeList;


}
