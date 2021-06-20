package com.example.orderappservice.service;

import com.example.orderappservice.bean.MBusiness;
import com.example.orderappservice.bean.MRider;
import com.example.orderappservice.bean.MUser;

import java.util.List;

public interface ManagerService {

    /*商家*/
    //商家列表
    List<MBusiness> getBusinessList();

    //通过id查询商家
    MBusiness getBusinessByBusinessId(Integer business_id);

    //添加商家信息
    int addBusiness(MBusiness mBusiness);

    //修改商家信息
    int updateBusinessByBusinessId(MBusiness mBusiness);

    //修改商家状态
    int updateBusinessStateByBusinessId(Integer business_id);

    //商家数量
    int getBusinessCount();

    /*用户*/
    //用户列表
    List<MUser> getUserList();

    //通过id查询用户
    MUser getUserByUserId(Integer user_id);

    //添加用户信息
    int addUser(MUser mUser);

    //删除用户
    int updateUserStateByUserId(Integer user_id);

    //用户数量
    int getUserCount();

    /*骑手*/
    //骑手列表
    List<MRider> getRiderList();

    //通过id查询骑手
    MRider getRiderByRiderId(Integer rider_id);

    //添加骑手信息
    int addRider(MRider mRider);

    //删除骑手
    int deleteRiderByRiderId(Integer rider_id);
//    int deleteRider(Integer rider_id);

    //骑手数量
    int getRiderCount();

    /*商品*/
    //商家的商品状态
    int updateProductStateByBusinessId(Integer business_id);

    //订单总数
    int getOrderCount();

//    /*订单*/
//    //用户的订单状态
//    int updateOrderStateByUserId(Integer user_id);

//    //查询商家订单总数
//    List<Order> getTotalOrderByBusinessId(Integer business_id);

}
