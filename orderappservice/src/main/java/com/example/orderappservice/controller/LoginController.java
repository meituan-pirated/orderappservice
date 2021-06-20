package com.example.orderappservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

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
public class LoginController {

    @RequestMapping("/manager/login")
    public String login(Model model){
        return "login";
    }

    @RequestMapping("/manager/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/manager/login";

        @Autowired
    private LoginService loginService;

    @PostMapping("/LoginOpera/loginByPhone")
    @ResponseBody
    public RestFulBean<Integer> loginByPhone(@RequestParam("phone")String phone,@RequestParam("password")String password,@RequestParam("user_type")Integer user_type){
        System.out.println(user_type);
        System.out.println(phone);
        System.out.println(password);
        return loginService.getLoginByPhone(phone,password,user_type);
    }

    @PostMapping("/LoginOpera/loginById")
    @ResponseBody
    public RestFulBean<Integer> loginById(@RequestParam("user_id")Integer user_id,@RequestParam("password")String password,
                                        @RequestParam("user_type")Integer user_type){
        System.out.println(user_type);
        System.out.println(user_id);
        System.out.println(password);
        return loginService.getLoginById(user_id,password,user_type);
    }

}
