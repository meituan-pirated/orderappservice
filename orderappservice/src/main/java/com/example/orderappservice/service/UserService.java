package com.example.orderappservice.service;

import com.example.orderappservice.bean.RestFulBean;
import com.example.orderappservice.pojo.OrderDetailsForR;
import com.example.orderappservice.pojo.OrderDetailsForU;
import com.example.orderappservice.pojo.OrderForR;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserService {

    RestFulBean<List<OrderForR>> getIngOrderList(Integer user_id);

    RestFulBean<List<OrderForR>> getFinishedOrderList(Integer user_id);

    RestFulBean<OrderDetailsForU> getOrderDetails(Integer order_id);
}
