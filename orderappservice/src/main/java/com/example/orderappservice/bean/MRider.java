package com.example.orderappservice.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MRider {
    private Integer rider_id;
    private String name;
    private String sex;
    private Integer phoneNumber;
    private String password;
}
