package com.example.orderappservice.service;

import com.example.orderappservice.bean.RestFulBean;
import com.example.orderappservice.pojo.*;

import java.util.List;

public interface MerchantService {
    //查询商家
    List<Business> getBusinessList();

    RestFulBean<Order> getOrderByOrderId(Integer order_id);

    RestFulBean<Order> getOrderByOrderState(Integer business_id, String order_state);

    int updateOrderStateByOrderId(Integer order_id, String order_state);

    int deleteProduct(Integer product_id);

    int addProduct(Products products);

//    //查询
//    List<User> getUserList();
//    //根据id查询商家
//    List<Business> getBusinessByBusinessId(int id);
//
//    List<Products> getProductList();
}
