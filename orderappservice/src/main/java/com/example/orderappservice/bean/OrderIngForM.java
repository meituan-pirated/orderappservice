package com.example.orderappservice.bean;

import com.example.orderappservice.pojo.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderIngForM {
    private int order_id;//订单编号
    //    private int user_id; //用户编号
    private int business_id; //商家编号
//    private int rider_id; //骑手编号

    private String orderNote; //商品备注
    private String orderState;//订单状态：待处理，进行中，已完成，已取消

    private RiderForM rider;

//    private Address address; //地址信息

    private List<OrderDetails> orderDetailsList; //订单详细信息

//    private String orderPrice;//实付金额
    private String orderTime;
}
