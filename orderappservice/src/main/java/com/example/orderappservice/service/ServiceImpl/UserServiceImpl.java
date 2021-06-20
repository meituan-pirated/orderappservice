package com.example.orderappservice.service.ServiceImpl;

import com.example.orderappservice.bean.RestFulBean;
import com.example.orderappservice.mapper.OrderMapper;
import com.example.orderappservice.pojo.OrderDetailsForR;
import com.example.orderappservice.pojo.OrderDetailsForU;
import com.example.orderappservice.pojo.OrderForR;
import com.example.orderappservice.service.UserService;
import com.example.orderappservice.util.RestFulUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private OrderMapper orderMapper;


    @Override
    public RestFulBean<List<OrderForR>> getIngOrderList(Integer user_id) {
        List<OrderForR> orderList = orderMapper.getIngOrderForUList(user_id);

        return RestFulUtil.getInstance().getResuFulBean(orderList, 0, "所有进行中的订单");
    }

    @Override
    public RestFulBean<List<OrderForR>> getFinishedOrderList(Integer user_id) {
        List<OrderForR> orderList = orderMapper.getFinishedOrderForUList(user_id);

        return RestFulUtil.getInstance().getResuFulBean(orderList, 0, "所有已完成的订单");
    }

    @Override
    public RestFulBean<OrderDetailsForU> getOrderDetails(Integer order_id) {
        OrderDetailsForU list =  orderMapper.getOrderDetailsForUByOrderId(order_id);
        return RestFulUtil.getInstance().getResuFulBean(list, 0, "订单详情");
    }
}
