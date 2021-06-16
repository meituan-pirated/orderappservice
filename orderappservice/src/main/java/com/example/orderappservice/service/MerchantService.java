package com.example.orderappservice.service;

import com.example.orderappservice.bean.*;
import com.example.orderappservice.pojo.Business;
import com.example.orderappservice.pojo.Order;
import com.example.orderappservice.pojo.Products;

import java.util.List;

public interface MerchantService {
    //查询商家
    List<Business> getBusinessList();

    RestFulBean<Order> getOrderByOrderId(Integer order_id);

    RestFulBean<Order> getOrderByOrderState(Integer business_id, String order_state);

    RestFulBean<OrderIngForM> getOrderIngByBusinessId(Integer business_id, String order_state);

    RestFulBean<OrderDoneBriefForM> getOrderDoneByBusinessId(Integer business_id, String order_state);

    RestFulBean<OrderDoneInfoForM> getOrderDoneInfoByOrderId(Integer order_id);

    RestFulBean<String> updateOrderStateByOrderId(Integer order_id, String order_state);

    RestFulBean<Business> getBusinessInfo(Integer business_id);

    RestFulBean<ProductBriefForM> getProductBriefForMByBusinessId(Integer business_id);

    RestFulBean<Products> getProductByProductId(Integer product_id);

    RestFulBean<String> saveProductChange(Products products);

    RestFulBean<String> deleteProduct(Integer product_id);

    RestFulBean<String> addProduct(Products products);

}
