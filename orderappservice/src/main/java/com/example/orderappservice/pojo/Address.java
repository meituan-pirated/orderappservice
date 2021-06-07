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
public class Address {
    private Integer address_id;
    private String receiveName;
    private String receivePhone;
    private String addressName;


//    //一个用户可以有多个地址
//    private User user;
//    //一个地址可以在多个订单中使用
//    private Set<Order> orderSet = new HashSet<Order>();


}

