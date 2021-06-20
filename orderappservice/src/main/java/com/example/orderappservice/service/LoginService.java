package com.example.orderappservice.service;

import com.example.orderappservice.bean.RestFulBean;
import com.example.orderappservice.pojo.Business;
import com.example.orderappservice.pojo.Login;
import com.example.orderappservice.pojo.Order;
import com.example.orderappservice.pojo.Products;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface LoginService {
    //查询账号

    RestFulBean<Integer> getLoginById(Integer user_id,String password, Integer user_type);

    RestFulBean<Integer> getLoginByPhone(String phone,String password, Integer user_type);


//    //查询
//    List<User> getUserList();
//    //根据id查询商家
//    List<Business> getBusinessByBusinessId(int id);
//
//    List<Products> getProductList();
}
