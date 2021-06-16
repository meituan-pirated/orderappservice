package com.example.orderappservice.bean;

import com.example.orderappservice.pojo.OrderDetails;
import com.example.orderappservice.pojo.Rider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDoneInfoForM {
    private int order_id;

    private List<OrderDetails> orderDetailsList;

    private Rider rider;

    private String orderTime;
    private String arriveTime;
}
