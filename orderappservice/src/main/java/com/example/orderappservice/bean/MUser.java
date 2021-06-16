package com.example.orderappservice.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MUser {
    private Integer user_id;
    private String name;
    private String sex;
    private Integer phoneNumber;
    private String password;
}
