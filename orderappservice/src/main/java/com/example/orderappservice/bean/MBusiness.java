package com.example.orderappservice.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MBusiness<business> {
    private Integer business_id;
    private String businessName;
    private String refectory;
    private String descriptions;
}
