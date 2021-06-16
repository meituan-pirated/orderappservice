package com.example.orderappservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttributeList {
    private int attributeListId;


    private Set<AttributeOption> attributeOptionSet = new HashSet<AttributeOption>();
//
//    //AttributeOption和OrderDetails的多对多的关系
//    //这里为多的一方
//    private Set<OrderDetails> orderDetailsSet = new HashSet<OrderDetails>();
//
//
}
