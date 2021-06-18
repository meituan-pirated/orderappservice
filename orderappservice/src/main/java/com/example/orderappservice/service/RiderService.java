package com.example.orderappservice.service;

import com.example.orderappservice.bean.RestFulBean;
import com.example.orderappservice.pojo.OrderDetailsForR;
import com.example.orderappservice.pojo.OrderForR;
import com.example.orderappservice.pojo.OrderStaForR;
import com.example.orderappservice.pojo.Rider;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface RiderService {

    //rider_id获取骑手全部信息
    RestFulBean<Rider> getRiderInfo(Integer rider_id);

    RestFulBean<List<OrderForR>> getNewOrderList();

    RestFulBean<List<OrderForR>> getUnderwayOrderList(Integer rider_id);

    RestFulBean<Integer> updateOrderStateByOrderId(Integer order_id, String order_state);

    RestFulBean<Integer> ChangeRiderInfo(Integer riderID, String newNickName, String newSex, String finalPwd,String advatar);

    RestFulBean<Integer>updateOrderRider(Integer order_id,Integer riderID);

    RestFulBean<OrderDetailsForR> getOrderDetails(Integer order_id);

    RestFulBean<Integer> markOrderArrive(Integer order_id);

    RestFulBean<OrderStaForR> getOrderSta(Integer rider_id);

}
