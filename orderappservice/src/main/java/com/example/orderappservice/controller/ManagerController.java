package com.example.orderappservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/manager")
//@RequestMapping("/Manager")
public class ManagerController {

//    @Autowired
//    private ManagerService managerService;

    @RequestMapping("/index.html")
    public String test(Model model){
        return "index";
    }

    @RequestMapping("/merchant.html")
    public String m1(Model model){
        return "merchant";
    }

}
