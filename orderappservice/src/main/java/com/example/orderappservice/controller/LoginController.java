package com.example.orderappservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/manager/login")
    public String login(Model model){
        return "login";
    }

    @RequestMapping("/manager/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/manager/login";
    }
}
