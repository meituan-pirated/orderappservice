package com.example.orderappservice.service.ServiceImpl;

import com.example.orderappservice.bean.RestFulBean;
import com.example.orderappservice.mapper.BusinessMapper;
import com.example.orderappservice.mapper.LoginMapper;
import com.example.orderappservice.mapper.OrderMapper;
import com.example.orderappservice.mapper.RiderMapper;
import com.example.orderappservice.pojo.*;
import com.example.orderappservice.service.RiderService;
import com.example.orderappservice.util.RestFulUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RiderServicelmpl implements RiderService {
    @Autowired
    private RiderMapper riderMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private BusinessMapper bMapper;
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public RestFulBean<Rider> getRiderInfo(Integer rider_id) {
        Rider rider = riderMapper.getRiderInfo(rider_id);
        System.out.println(rider.getNickName());
        return RestFulUtil.getInstance().getResuFulBean(rider, 0, "骑手信息");
    }

    @Override
    public RestFulBean<List<OrderForR>> getNewOrderList() {
        List<OrderForR> orderList = orderMapper.getNewOrderList();

        return RestFulUtil.getInstance().getResuFulBean(orderList, 0, "所有新订单");
    }

    @Override
    public RestFulBean<List<OrderForR>> getUnderwayOrderList(Integer rider_id) {
        List<OrderForR> orderList = orderMapper.getUnderwayOrderList(rider_id);

        return RestFulUtil.getInstance().getResuFulBean(orderList, 0, "所有进行中的订单");
    }

    @Override
    public RestFulBean<Integer> updateOrderStateByOrderId(Integer order_id, String order_state) {
        int res = orderMapper.updateOrderStateByOrderId(order_state,order_id);
        return RestFulUtil.getInstance().getResuFulBean(res, 0, "更改订单状态结果");
    }

    @Override
    public RestFulBean<Integer> ChangeRiderInfo(Integer riderID, String newNickName, String newSex, String finalPwd) {
        int update_login = loginMapper.updateLoginById(finalPwd,riderID);
        int update_rider = riderMapper.updateRiderByRiderId(newSex,newNickName,finalPwd,riderID);

        return RestFulUtil.getInstance().getResuFulBean(update_login*update_rider, 0, "更新骑手账号信息的结果");
    }

    @Override
    public RestFulBean<Integer> updateOrderRider(Integer order_id, Integer riderID) {
        int update_rider = orderMapper.updateOrderRider(order_id,riderID);

        return RestFulUtil.getInstance().getResuFulBean(update_rider, 0, "更新订单骑手信息的结果");

    }

    @Override
    public RestFulBean<OrderDetailsForR> getOrderDetails(Integer order_id) {
        OrderDetailsForR list =  orderMapper.getOrderDetailsForRByOrderId(order_id);
        return RestFulUtil.getInstance().getResuFulBean(list, 0, "订单详情");

    }

    @Override
    public RestFulBean<Integer> markOrderArrive(Integer order_id) {
        String time = "";

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        time += sdf.format(date);//获取当下时间
        int res = orderMapper.markOrderArrive(order_id,time);
        return RestFulUtil.getInstance().getResuFulBean(res, 0, "订单到达时间已记录");
    }

    @Override
    public RestFulBean<OrderStaForR> getOrderSta(Integer rider_id) {
        List<OrderForR> finishedList = orderMapper.getFinishedOrderForR(rider_id);
        String date = "";
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        date = date + sdf.format(new Date()) + " 00:00:00";//获取当下时间
        System.out.println(date);
        Integer quantity = orderMapper.getTodayOrderByRiderId(date);//今天的单数
        System.out.println("今日单数"+quantity);
        Integer income = quantity *4;
        OrderStaForR sta = new OrderStaForR();
        sta.setFinishedOrderList(finishedList);
        sta.setQuantity(quantity);
        sta.setIncome(income);
        return RestFulUtil.getInstance().getResuFulBean(sta, 0, "订单到达时间已记录");

    }


}
