package com.example.orderappservice.service.ServiceImpl;

import com.example.orderappservice.bean.MBusiness;
import com.example.orderappservice.bean.MRider;
import com.example.orderappservice.bean.MUser;
import com.example.orderappservice.mapper.*;
import com.example.orderappservice.pojo.Products;
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
    private RiderMapper riderMapper;

    @Autowired
    private ProductsMapper productsMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<MBusiness> getBusinessList() {

        return businessMapper.getBusinessList();
    }

    @Override
    public int addBusiness(MBusiness mBusiness) {
        return businessMapper.addBusiness(mBusiness);
    }

    @Override
    public MBusiness getBusinessByBusinessId(Integer business_id) {
        return businessMapper.getBusinessByBusinessId(business_id);
    }

    @Override
    public int updateBusinessByBusinessId(MBusiness mBusiness) {
        return businessMapper.updateBusinessByBusinessId(mBusiness);
    }

    @Override
    public int updateBusinessStateByBusinessId(Integer business_id) {
        int res = businessMapper.updateBusinessStateByBusinessId(business_id);
//        System.out.printf(res+"");
        return res;
    }

    @Override
    public int getBusinessCount() {
        return businessMapper.getBusinessCount();
    }

    @Override
    public int updateProductStateByBusinessId(Integer business_id) {
        return productsMapper.updateProductStateByBusinessId(business_id);
    }

    @Override
    public int getOrderCount() {
        return orderMapper.getOrderCount();
    }

//    @Override
//    public int updateOrderStateByUserId(Integer user_id) {
//        return orderMapper.updateOrderStateByUserId(user_id);
//    }

    @Override
    public List<MUser> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public int addUser(MUser mUser) {
        return userMapper.addUser(mUser);
    }

    @Override
    public int updateUserStateByUserId(Integer user_id) {
        return userMapper.updateUserStateByUserId(user_id);
    }

    @Override
    public int getUserCount() {
        return userMapper.getUserCount();
    }

    @Override
    public MUser getUserByUserId(Integer user_id) {
        return userMapper.getUserByUserId(user_id);
    }

    @Override
    public List<MRider> getRiderList() {
        return riderMapper.getRiderList();
    }

    @Override
    public MRider getRiderByRiderId(Integer rider_id) {
        return riderMapper.getRiderByRiderId(rider_id);
    }

    @Override
    public int addRider(MRider mRider) {
        return riderMapper.addRider(mRider);
    }

    @Override
    public int deleteRiderByRiderId(Integer rider_id) {
        return riderMapper.deleteRiderByRiderId(rider_id);
    }

    @Override
    public int getRiderCount() {
        return riderMapper.getRiderCount();
    }

//    @Override
//    public int deleteRider(Integer rider_id) {
//        return riderMapper.deleteRider(rider_id);
//    }

}
