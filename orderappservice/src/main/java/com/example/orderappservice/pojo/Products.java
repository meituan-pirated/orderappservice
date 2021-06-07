package com.example.orderappservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products {
    private Integer product_id;
    private String productName;
    private String descriptions;
    private Integer salePrice;
    private Integer deliveryPrice;
    private String image;

    //一个商家可以有多个商品，商品为多的一方
    private Business business;

    //一个商品可以有多个属性可选择，products为一的一方
    private List<Attribute> attributeList;

    //    //商品和订单多对多，转为和中间表的一对多
//    //商品为多的一方
//    private OrderDetails orderDetails;
}
