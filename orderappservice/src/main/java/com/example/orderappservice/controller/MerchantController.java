package com.example.orderappservice.controller;

import com.example.orderappservice.bean.RestFulBean;
import com.example.orderappservice.pojo.Business;
import com.example.orderappservice.pojo.Order;
import com.example.orderappservice.pojo.OrderDetails;
import com.example.orderappservice.pojo.Products;
import com.example.orderappservice.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/MerchantOpera")
public class MerchantController {
    @Autowired
    private MerchantService merchantService;

    @GetMapping("/getOrderList")
    @ResponseBody
    public RestFulBean<Order> getOrder(@RequestParam("order_id")Integer order_id){
        return merchantService.getOrderByOrderId(order_id);
    }

    @GetMapping("/getWaitOrderList")
    @ResponseBody
    public RestFulBean<Order> getWaitOrder(@RequestParam("business_id") Integer business_id){
        return merchantService.getOrderByOrderState(business_id, "WAIT");
    }

    @GetMapping("/changeOrderState")
    @ResponseBody
    public int acceptOrder(@RequestParam("order_id")Integer order_id,@RequestParam("order_state")String order_state){
        return merchantService.updateOrderStateByOrderId(order_id, order_state);
    }

    @PostMapping("/addProduct")
    @ResponseBody
    public int addProduct(@RequestBody Products products){
        return merchantService.addProduct(products);
    }

    @GetMapping("/deleteProduct")
    @ResponseBody
    public int deleteProduct(@RequestParam("product_id")Integer product_id){
        return merchantService.deleteProduct(product_id);
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
