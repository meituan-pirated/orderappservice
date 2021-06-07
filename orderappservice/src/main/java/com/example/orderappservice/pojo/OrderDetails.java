package com.example.orderappservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {
    private int order_details_id;
    private Integer amount;

    //将order与products的多对多关系，转化成中间表和各自的一对多关系
    //orderDetails为一的一方
    private Products product;


//    //将订单中每一项商品的属性值和订单中一列商品的多对多的关系转化成一对多的关系
//    // orderDetails为多的一方
//    private AttributeList attributeList;


}
