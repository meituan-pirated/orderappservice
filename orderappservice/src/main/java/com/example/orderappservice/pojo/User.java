package com.example.orderappservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer user_id;
    private String name;
    private String nickName;
    private String sex;
    private Integer phoneNumber;
    private String password;

    private List<Address> addressList;
//    private Set<Order> orderSet = new HashSet<Order>();


}
