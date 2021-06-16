package com.example.orderappservice.controller;


import com.example.orderappservice.bean.RestFulBean;
import com.example.orderappservice.pojo.Business;
import com.example.orderappservice.pojo.Login;
import com.example.orderappservice.pojo.Order;
import com.example.orderappservice.service.LoginService;
import com.example.orderappservice.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/LoginOpera")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/loginByPhone")
    @ResponseBody
    public RestFulBean<Integer> loginByPhone(@RequestParam("phone")String phone,@RequestParam("password")String password,@RequestParam("user_type")Integer user_type){
        System.out.println(user_type);
        System.out.println(phone);
        System.out.println(password);
        return loginService.getLoginByPhone(phone,password,user_type);
    }

    @PostMapping("/loginById")
    @ResponseBody
    public RestFulBean<Integer> loginById(@RequestParam("user_id")Integer user_id,@RequestParam("password")String password,
                                        @RequestParam("user_type")Integer user_type){
        System.out.println(user_type);
        System.out.println(user_id);
        System.out.println(password);
        return loginService.getLoginById(user_id,password,user_type);
    }

}
