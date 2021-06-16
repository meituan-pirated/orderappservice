package com.example.orderappservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
//提供一个无参构造
@NoArgsConstructor
//所有的有参构造
@AllArgsConstructor
public class Business {
    private Integer business_id;
    private String businessName;
    private String refectory;
    private String descriptions;
    private int businessImage;

    //一对多的关系，为一的一方
    private List<Products> productsList;
}
