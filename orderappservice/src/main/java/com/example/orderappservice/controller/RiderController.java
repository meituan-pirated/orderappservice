package com.example.orderappservice.controller;

import com.example.orderappservice.bean.RestFulBean;
import com.example.orderappservice.pojo.*;
import com.example.orderappservice.service.MerchantService;
import com.example.orderappservice.service.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/RiderOpera")
public class RiderController {
    @Autowired
    private RiderService riderService;


    @GetMapping("/getRiderInfo")
    @ResponseBody
    public RestFulBean<Rider> getRiderInfo(@RequestParam("rider_id")Integer rider_id){
        return riderService.getRiderInfo(rider_id);
    }

    @GetMapping("/getNewOrderList")
    @ResponseBody
    public RestFulBean<List<OrderForR>> getNewOrderList(){
        return riderService.getNewOrderList();
    }


    @GetMapping("/getUnderwayOrderList")
    @ResponseBody
    public RestFulBean<List<OrderForR>> getUnderwayOrderList(@RequestParam("rider_id")Integer rider_id){
        return riderService.getUnderwayOrderList(rider_id);
    }

    @PostMapping("/changeRiderInfo")
    @ResponseBody
    public RestFulBean<Integer> changeRiderInfo(@RequestParam("rider_id")Integer rider_id, @RequestParam("nick_name")String nick_name,
                                                @RequestParam("sex")String sex,@RequestParam("password")String password,
                                                @RequestParam("advatar")String advatar){
        System.out.println(password);
        return riderService.ChangeRiderInfo(rider_id,nick_name,sex,password,advatar);
    }

    @GetMapping("/changeOrderState")
    @ResponseBody
    public RestFulBean<Integer> changeOrderState(@RequestParam("order_id")Integer order_id, @RequestParam("next_state")String next_state){
        return riderService.updateOrderStateByOrderId(order_id, next_state);
    }

    @GetMapping("/acceptOrder")
    @ResponseBody
    public RestFulBean<Integer> acceptOrder(@RequestParam("order_id")Integer order_id, @RequestParam("rider_id")Integer rider_id){
        return riderService.updateOrderRider(order_id, rider_id);
    }

    @GetMapping("/getOrderDetails")
    @ResponseBody
    public RestFulBean<OrderDetailsForR> getOrderDetails(@RequestParam("order_id")Integer order_id){
        return riderService.getOrderDetails(order_id);
    }

    @GetMapping("/markOrderArrive")
    @ResponseBody
    public RestFulBean<Integer> markOrderArrive(@RequestParam("order_id")Integer order_id){
        return riderService.markOrderArrive(order_id);
    }

    @GetMapping("/getOrderSta")
    @ResponseBody
    public RestFulBean<OrderStaForR> getOrderSta(@RequestParam("rider_id")Integer rider_id){
        return riderService.getOrderSta(rider_id);
    }



}
