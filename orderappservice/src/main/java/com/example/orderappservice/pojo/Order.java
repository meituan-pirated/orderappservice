package com.example.orderappservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int order_id;
    private int user_id;
    private int business_id;
    private int rider_id;

    private String orderNote;
    private String orderState;

    //一个地址可以有多个订单
    private Address address;

    //订单和商品之间的多对多关系转化为和中间表orderDetails的一对多关系
    //订单表为多的一方
    private List<OrderDetails> orderDetailsList;

    private String orderPrice;
    private String orderTime;
    private Integer riderScore;
    private Integer businessScore;


}

