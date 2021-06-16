package com.example.orderappservice.service;

import com.example.orderappservice.pojo.Business;
import com.example.orderappservice.pojo.Order;
import com.example.orderappservice.pojo.User;

import java.util.List;

public interface ManagerService {
    //查询商家订单总数
    List<Order> getTotalOrderByBusinessId(Integer business_id);

    //增加商家信息
    int addBusiness(Business business);

    //更新商家信息
    int updateBusinessByBusinessId(Business business);

    //删除商家信息
    int deleteBusiness(Integer business_id);

    //查询用户订单总数
    List<Order> getTotalOrderByUserId(Integer user_id);

    //增加用户信息
    int addUser(User user);

    //删除用户信息
    int deleteUser(Integer user_id);

    //查询骑手接单总数

    //增加骑手信息

    //删除骑手信息
}
