package com.example.orderappservice.service.ServiceImpl;

import com.example.orderappservice.bean.RestFulBean;
import com.example.orderappservice.mapper.BusinessMapper;
import com.example.orderappservice.mapper.LoginMapper;
import com.example.orderappservice.pojo.Login;
import com.example.orderappservice.service.LoginService;
import com.example.orderappservice.service.MerchantService;
import com.example.orderappservice.util.RestFulUtil;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServicelmpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public RestFulBean<Integer> getLoginById(Integer user_id, String password, Integer user_type){
        Login login = loginMapper.getLoginById(user_id);
        if(login==null){
            return RestFulUtil.getInstance().getResuFulBean(null, 0, "账号不存在");
        }else if(login.getUser_type()!=user_type){
            System.out.println(login.getUser_type());
            return RestFulUtil.getInstance().getResuFulBean(null, 0, "账号类型不正确");
        }else if(!login.getPassword().equals(password)){
            return RestFulUtil.getInstance().getResuFulBean(null, 0, "密码不正确");
        }else {
            return RestFulUtil.getInstance().getResuFulBean(user_id, 0, "账号验证通过");
        }


    }

    @Override
    public RestFulBean<Integer> getLoginByPhone(String phone,String password, Integer user_type){
        Login login = loginMapper.getLoginByPhone(phone);
        if(login==null){
            return RestFulUtil.getInstance().getResuFulBean(null, 0, "账号不存在");
        }else if(login.getUser_type()!=user_type){
            return RestFulUtil.getInstance().getResuFulBean(null, 0, "账号类型不正确");
        }else if(!login.getPassword().equals(password)){
            return RestFulUtil.getInstance().getResuFulBean(null, 0, "密码不正确");
        }else {
            return RestFulUtil.getInstance().getResuFulBean(login.getUser_id(), 0, "账号验证通过");
        }
    }

}
