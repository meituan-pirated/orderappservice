package com.example.orderappservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rider {
    private int rider_id;
    private String name;
    private String nickName;
    private String phoneNumber;
    private String advatar;
}
