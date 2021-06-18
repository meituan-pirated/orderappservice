package com.example.orderappservice.controller;

import com.example.orderappservice.bean.*;
import com.example.orderappservice.pojo.Business;
import com.example.orderappservice.pojo.Order;
import com.example.orderappservice.pojo.OrderDetails;
import com.example.orderappservice.pojo.Products;
import com.example.orderappservice.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/MerchantOpera")
public class MerchantController {
    @Autowired
    private MerchantService merchantService;

    @GetMapping("/queryBusiness")
    @ResponseBody
    public List<Business> queryBusiness(){
        return merchantService.getBusinessList();
    }

    @GetMapping("/getOrderList")
    @ResponseBody
    public RestFulBean<Business> getBusinessInfo(@RequestParam("business_id") Integer business_id){
        return merchantService.getBusinessInfo(business_id);
    }

    @GetMapping("/getWaitOrderList")
    @ResponseBody
    public RestFulBean<Order> getWaitOrder(@RequestParam("business_id") Integer business_id){
        return merchantService.getOrderByOrderState(business_id, "WAIT");
    }

    @GetMapping("/getIngOrderList")
    @ResponseBody
    public RestFulBean<OrderIngForM> getIngOrder(@RequestParam("business_id") Integer business_id){
        return merchantService.getOrderIngByBusinessId(business_id, "ING");
    }

    @GetMapping("/getDoneBriefOrderList")
    @ResponseBody
    public RestFulBean<OrderDoneBriefForM> getDoneBriefOrder(@RequestParam("business_id") Integer business_id){
        return merchantService.getOrderDoneByBusinessId(business_id, "DONE");
    }

    @GetMapping("/getDoneInfo")
    @ResponseBody
    public RestFulBean<OrderDoneInfoForM> getDoneInfo(@RequestParam("order_id") Integer order_id){
        return merchantService.getOrderDoneInfoByOrderId(order_id);
    }


//    @PostMapping(value = "/changeOrderState")
//    @ResponseBody
//    public RestFulBean acceptOrder(@RequestBody ChangeOrderBean changeOrderBean){
//        return merchantService.updateOrderStateByOrderId(changeOrderBean.getOrder_id(), changeOrderBean.getOrder_state());
//    }

    @PostMapping("/changeOrderState")
    @ResponseBody
    public RestFulBean<String> acceptOrder(@RequestParam("order_id") Integer order_id, @RequestParam("order_state") String order_state){
        return merchantService.updateOrderStateByOrderId(order_id, order_state);
    }

    @GetMapping("/getProductBriefForMList")
    @ResponseBody
    public RestFulBean<ProductBriefForM> getProductBriefForMList(@RequestParam("business_id") Integer business_id) {
        return merchantService.getProductBriefForMByBusinessId(business_id);
    }


    @GetMapping("/getProductInfo")
    @ResponseBody
    public RestFulBean<Products> getProductInfo(@RequestParam("product_id") Integer product_id) {
        return merchantService.getProductByProductId(product_id);
    }

    @PostMapping("/addProduct")
    @ResponseBody
    public RestFulBean<String> addProduct(Products products) throws IOException {
        System.out.println(products.getBusiness_id());
        return merchantService.addProduct(products);
    }

    @GetMapping("/deleteProduct")
    @ResponseBody
    public RestFulBean<String> deleteProduct(@RequestParam("product_id") Integer product_id){
        return merchantService.deleteProduct(product_id);
    }

    @PostMapping("/saveProductChange")
    @ResponseBody
    public RestFulBean<String> saveProductChange(Products products){
        return merchantService.saveProductChange(products);
    }







//    @GetMapping("/queryBusiness1")
//    @ResponseBody
//    public List<Business> queryBusiness1(){
//        return merchantService.getBusinessByBusinessId(12345678);
//    }
//
//
//    @GetMapping("/queryProduct")
//    @ResponseBody
//    public List<Products> queryProduct(){
//        return merchantService.getProductList();
//    }

}
