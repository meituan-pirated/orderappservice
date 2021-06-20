package com.example.orderappservice.controller;

import com.example.orderappservice.bean.RestFulBean;
import com.example.orderappservice.pojo.OrderDetailsForR;
import com.example.orderappservice.pojo.OrderDetailsForU;
import com.example.orderappservice.pojo.OrderForR;
import com.example.orderappservice.pojo.OrderStaForR;
import com.example.orderappservice.service.RiderService;
import com.example.orderappservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/UserOpera")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getIngOrderList")
    @ResponseBody
    public RestFulBean<List<OrderForR>> getIngOrderList(@RequestParam("user_id")Integer user_id){
        return userService.getIngOrderList(user_id);
    }

    @GetMapping("/getOrderDetails")
    @ResponseBody
    public RestFulBean<OrderDetailsForU> getOrderDetails(@RequestParam("order_id")Integer order_id){
        return userService.getOrderDetails(order_id);
    }

    @GetMapping("/getFinishedOrderList")
    @ResponseBody
    public RestFulBean<List<OrderForR>> getFinishedOrderList(@RequestParam("user_id")Integer user_id){
        return userService.getFinishedOrderList(user_id);
    }
}
