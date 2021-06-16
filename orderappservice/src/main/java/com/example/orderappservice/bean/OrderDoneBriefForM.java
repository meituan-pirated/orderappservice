package com.example.orderappservice.bean;

import com.example.orderappservice.pojo.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDoneBriefForM {

    private int order_id;//订单编号
    private int user_id; //用户编号
    private int business_id; //商家编号

    private String orderState;//订单状态：待处理，进行中，已完成，已取消



    private int orderPrice;//实付金额
    private List<OrderDetails> orderDetailsList; //订单详细信息
    private int totalAmount;

    private Integer businessScore;

}
