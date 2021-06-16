package com.example.orderappservice.service.ServiceImpl;

import com.example.orderappservice.mapper.*;
import com.example.orderappservice.pojo.Business;
import com.example.orderappservice.pojo.Order;
import com.example.orderappservice.pojo.User;
import com.example.orderappservice.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private BusinessMapper businessMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> getTotalOrderByBusinessId(Integer business_id) {
        return null;
    }

    @Override
    public int addBusiness(Business business) {
        return businessMapper.addBusiness(business);
    }

    @Override
    public int updateBusinessByBusinessId(Business business) {
        return 0;
    }

    @Override
    public int deleteBusiness(Integer business_id) {
        return 0;
    }

    @Override
    public List<Order> getTotalOrderByUserId(Integer user_id) {
        return null;
    }

    @Override
    public int addUser(User user) {
        return 0;
    }

    @Override
    public int deleteUser(Integer user_id) {
        return 0;
    }
}
