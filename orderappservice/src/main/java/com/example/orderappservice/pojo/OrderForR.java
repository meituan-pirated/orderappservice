package com.example.orderappservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderForR {

    private Integer order_id;
    private String order_state;
    private String arrive_time;
    private String order_time;
    private Integer rider_score;
    private Integer order_price;
    private Address address;

    private BusinessForR businessInfo;

}
