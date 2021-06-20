package com.example.orderappservice.controller;

import com.example.orderappservice.bean.MBusiness;
import com.example.orderappservice.bean.MRider;
import com.example.orderappservice.bean.MUser;
import com.example.orderappservice.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping("/index.html")
    public String test(Model model){
        model.addAttribute("orderCount",managerService.getOrderCount());
        model.addAttribute("businessCount",managerService.getBusinessCount());
        model.addAttribute("userCount",managerService.getUserCount());
        model.addAttribute("riderCount",managerService.getRiderCount());
        return "index";
    }

    /*商家*/
    //商家列表
    @RequestMapping("/merchant")
    public String m1(Model model){
        model.addAttribute("businessList", managerService.getBusinessList());
        return "merchant";
    }

    //增加商家信息
    @GetMapping("/addMerchant")
    public String toAddMerchant(){
//        model.addAttribute("addBusiness",managerService.addBusiness());
        return "addMerchant";
    }

    @PostMapping("/addMerchant")
    public String addMerchant(MBusiness mBusiness){
//        System.out.printf("add=>"+mBusiness);
//        mBusiness.setBusiness_id(null);
        managerService.addBusiness(mBusiness);
        return "redirect:/manager/merchant";
    }

    //根据ID查询商家
    @RequestMapping(value = "/getMerchant", method = RequestMethod.POST)
    public String getMerchant(@RequestParam("business_id") Integer business_id,Model model){
        MBusiness mBusiness = managerService.getBusinessByBusinessId(business_id);
        model.addAttribute("merchant",mBusiness);
        return "getMerchant";
    }

    //要修改的信息显示在修改框里
    @GetMapping("/update/{business_id}")
    public String toUpdateMerchant(@PathVariable("business_id")Integer business_id,Model model){
        //查出原来的数据
        MBusiness mBusiness = managerService.getBusinessByBusinessId(business_id);
        model.addAttribute("business",mBusiness);
        return "updateMerchant";
    }

    //修改商家信息
    @PostMapping("/updateMerchant")
    public String updateMerchant(MBusiness mBusiness){
//        System.out.printf(mBusiness.getBusinessName());
        managerService.updateBusinessByBusinessId(mBusiness);
        return "redirect:/manager/merchant";
    }

    //修改商家的状态
    @GetMapping("/merchant/delete/{business_id}")
    public String toDeleteBusiness(Model model, @PathVariable("business_id") Integer business_id){
//        System.out.printf(business_id+"");
        managerService.updateBusinessStateByBusinessId(business_id);
        managerService.updateProductStateByBusinessId(business_id);
        model.addAttribute("businessList", managerService.getBusinessList());
        return "merchant";
    }

    /*用户*/
    //用户列表
    @RequestMapping("/user")
    public String u1(Model model){
//        List<MUser> userList = managerService.getUserList();
//        System.out.printf(userList.get(0).getPhoneNumber()+"");
        model.addAttribute("userList",managerService.getUserList());
        return "user";
    }

    //添加用户信息
    @GetMapping("/addUser")
    public String toAddUser(){
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(MUser mUser){
        managerService.addUser(mUser);
        return "redirect:/manager/user";
    }

    //通过ID查询用户
    @RequestMapping(value = "/getUser",method = RequestMethod.POST)
    public String getUser(@RequestParam("user_id") Integer user_id,Model model){
        MUser mUser = managerService.getUserByUserId(user_id);
        model.addAttribute("user",mUser);
        return "getUser";
    }

    //删除用户
    @GetMapping("/user/delete/{user_id}")
    public String toDeleteUser(@PathVariable("user_id") Integer user_id,Model model){
        managerService.updateUserStateByUserId(user_id);
//        managerService.updateOrderStateByUserId(user_id);
        model.addAttribute("userList",managerService.getUserList());
        return "user";
    }

    /*骑手*/
    //骑手列表
    @RequestMapping("/rider")
    public String r1(Model model){
        model.addAttribute("riserList",managerService.getRiderList());
        return "rider";
    }

    //通过ID查询骑手
    @RequestMapping(value = "/getRider",method = RequestMethod.POST)
    public String getRider(@RequestParam("rider_id") Integer rider_id,Model model){
        MRider mRider = managerService.getRiderByRiderId(rider_id);
        model.addAttribute("rider",mRider);
        return "getRider";
    }

    //添加骑手信息
    @GetMapping("/addRider")
    public String toAddRider(){
        return "addRider";
    }

    @PostMapping("/addRider")
    public String addRider(MRider mRider){
        managerService.addRider(mRider);
        return "redirect:/manager/rider";
    }

    //删除骑手
    @GetMapping("/rider/delete/{rider_id}")
    public String toDeleteRider(@PathVariable("rider_id") Integer rider_id,Model model){
        managerService.deleteRiderByRiderId(rider_id);
        model.addAttribute("riderList",managerService.getRiderList());
        return "rider";
    }

//    @GetMapping("/deRider/{rider_id}")
//    public String deRider(@PathVariable("rider_id") Integer rider_id){
//        managerService.deleteRider(rider_id);
//        return "redirect:/manager/rider";
//    }


    /*统计*/
    @RequestMapping("/statistics")
    public String statistics(Model model){
        model.addAttribute("orderCount",managerService.getOrderCount());
        model.addAttribute("businessCount",managerService.getBusinessCount());
        model.addAttribute("userCount",managerService.getUserCount());
        model.addAttribute("riderCount",managerService.getRiderCount());
        return "statistics";
    }

    /*管理*/
    @RequestMapping("/manager")
    public String manager(){
        return "manager";
    }
}
