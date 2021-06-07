package com.example.orderappservice.service.ServiceImpl;

import com.example.orderappservice.bean.RestFulBean;
import com.example.orderappservice.mapper.BusinessMapper;
import com.example.orderappservice.mapper.OrderDetailsMapper;
import com.example.orderappservice.mapper.OrderMapper;
import com.example.orderappservice.mapper.ProductsMapper;
import com.example.orderappservice.pojo.Business;
import com.example.orderappservice.pojo.Order;
import com.example.orderappservice.pojo.OrderDetails;
import com.example.orderappservice.pojo.Products;
import com.example.orderappservice.service.MerchantService;
import com.example.orderappservice.util.RestFulUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    private BusinessMapper businessMapper;
    @Autowired
    private ProductsMapper productsMapper;

    @Autowired
    private OrderDetailsMapper orderDetailsMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Business> getBusinessList() {
        return businessMapper.getBusinessList();
    }

    @Override
    public RestFulBean<Order> getOrderByOrderId(Integer order_id) {
        List<Order> orderList = orderMapper.getOrderByOrderId(order_id);
        return RestFulUtil.getInstance().getResuFulBean(orderList, 0, "订单列表");
    }

    @Override
    public RestFulBean<Order> getOrderByOrderState(Integer business_id, String order_state) {
        List<Order> orderList = orderMapper.getOrderByOrderState(business_id, order_state);
        return RestFulUtil.getInstance().getResuFulBean(orderList, 0, "订单列表");
    }


    @Override
    public int updateOrderStateByOrderId(Integer order_id, String order_state) {
        return orderMapper.updateOrderStateByOrderId(order_state,order_id);
    }

    @Override
    public int deleteProduct(Integer product_id) {
        return productsMapper.deleteProduct(product_id);
    }

    @Override
    public int addProduct(Products products) {
        return productsMapper.addProduct(products);
    }


//    @Override
//    public List<Business> getBusinessByBusinessId(int id) {
//        return businessMapper.getBusinessByBusinessId(id);
//    }
//
//    @Override
//    public List<Products> getProductList() {
//        return productsMapper.getProductsList();
//    }
}
