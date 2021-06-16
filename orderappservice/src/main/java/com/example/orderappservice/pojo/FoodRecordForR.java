package com.example.orderappservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodRecordForR {
    private int id;
    private String name;
    private double price;//价格
    public int count;//购买数量
}

