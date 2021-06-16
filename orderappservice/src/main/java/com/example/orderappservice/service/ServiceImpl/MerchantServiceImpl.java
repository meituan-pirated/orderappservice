package com.example.orderappservice.service.ServiceImpl;

import com.example.orderappservice.bean.*;
import com.example.orderappservice.mapper.BusinessMapper;
import com.example.orderappservice.mapper.OrderDetailsMapper;
import com.example.orderappservice.mapper.OrderMapper;
import com.example.orderappservice.mapper.ProductsMapper;
import com.example.orderappservice.pojo.Business;
import com.example.orderappservice.pojo.Order;
import com.example.orderappservice.pojo.Products;
import com.example.orderappservice.service.MerchantService;
import com.example.orderappservice.util.RestFulUtil;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    private BusinessMapper businessMapper;
    @Autowired
    private ProductsMapper productsMapper;

    @Autowired
    private OrderDetailsMapper orderDetailsMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Business> getBusinessList() {
        return businessMapper.getBusinessList();
    }

    @Override
    public RestFulBean<Order> getOrderByOrderId(Integer order_id) {
        Order order = orderMapper.getOrderByOrderId(order_id);
        return RestFulUtil.getInstance().getResuFulBean(order, 0, "订单列表");
    }

    @Override
    public RestFulBean<Order> getOrderByOrderState(Integer business_id, String order_state) {
        List<Order> orderList = orderMapper.getOrderByOrderState(business_id, order_state);
        return RestFulUtil.getInstance().getResuFulBean(orderList, 0, "订单列表");
    }

    @Override
    public RestFulBean<OrderIngForM> getOrderIngByBusinessId(Integer business_id, String order_state) {
        List<OrderIngForM> orderList = orderMapper.getOrderIngByBusinessId(business_id, order_state);
        return RestFulUtil.getInstance().getResuFulBean(orderList, 0, "订单列表");
    }

    @Override
    public RestFulBean<OrderDoneBriefForM> getOrderDoneByBusinessId(Integer business_id, String order_state) {
        List<OrderDoneBriefForM> orderList = orderMapper.getOrderDoneByBusinessId(business_id, order_state);
        return RestFulUtil.getInstance().getResuFulBean(orderList, 0, "订单列表");
    }

    @Override
    public RestFulBean<OrderDoneInfoForM> getOrderDoneInfoByOrderId(Integer order_id) {
        OrderDoneInfoForM orderList = orderMapper.getOrderDoneInfoForMByOrderId(order_id);
        return RestFulUtil.getInstance().getResuFulBean(orderList, 0, "已完成订单详细信息");
    }


    @Override
    public RestFulBean<String> updateOrderStateByOrderId(Integer order_id, String order_state) {
        int result = orderMapper.updateOrderStateByOrderId(order_state,order_id);
        if(result == 1){
            return RestFulUtil.getInstance().getResuFulBean("", 0, "成功修改订单状况");
        }else{
            return RestFulUtil.getInstance().getResuFulBean("", -1, "修改订单状况失败");
        }

    }

    @Override
    public RestFulBean<Business> getBusinessInfo(Integer business_id) {
        Business business = businessMapper.getBusinessByBusinessId(business_id);
        return RestFulUtil.getInstance().getResuFulBean(business, 0, "获取店铺信息成功");
    }


    @Override
    public RestFulBean<ProductBriefForM> getProductBriefForMByBusinessId(Integer business_id) {
        List<ProductBriefForM> productBriefForMList = productsMapper.getProductBriefForMByBusinessId(business_id);
        return RestFulUtil.getInstance().getResuFulBean(productBriefForMList, 0, "查询简略商品列表成功");
    }



    @Override
    public RestFulBean<Products> getProductByProductId(Integer product_id) {
        Products products = productsMapper.getProductByProductId(product_id);
        return RestFulUtil.getInstance().getResuFulBean(products, 0, "查询商品信息成功");
    }

    @Override
    public RestFulBean<String> saveProductChange(Products products) {
        try {
//            System.out.println(products.getImage());
            // Base64解码图片
            byte[] imageByteArray = Base64.decodeBase64(products.getImage());

            String uuid = UUID.randomUUID().toString().replaceAll("-", "");

            FileOutputStream imageOutFile = new FileOutputStream("E:/android/pics/" + uuid+".jpg");
            imageOutFile.write(imageByteArray);

            imageOutFile.close();
            System.out.println(imageByteArray);
            System.out.println(uuid);
            products.setImage(uuid);

            System.out.println("Image Successfully Stored");
        } catch (FileNotFoundException fnfe) {
            System.out.println("Image Path not found" + fnfe);
        } catch (IOException ioe) {
            System.out.println("Exception while converting the Image " + ioe);
        }

        int result = productsMapper.saveProductChange(products);
        if(result == 1){
            return RestFulUtil.getInstance().getResuFulBean("", 0, "成功添加商品");
        }else{
            return RestFulUtil.getInstance().getResuFulBean("", -1, "添加商品失败");
        }
    }


    @Override
    public RestFulBean<String> deleteProduct(Integer product_id) {
        int result = productsMapper.deleteProduct(product_id);
        if(result == 1){
            return RestFulUtil.getInstance().getResuFulBean("", 0, "成功删除商品");
        }else{
            return RestFulUtil.getInstance().getResuFulBean("", -1, "删除商品失败");
        }
    }

    @Override
    public RestFulBean<String> addProduct(Products products) {
        int result = productsMapper.addProduct(products);
        if(result == 1){
            return RestFulUtil.getInstance().getResuFulBean("", 0, "成功添加商品");
        }else{
            return RestFulUtil.getInstance().getResuFulBean("", -1, "添加商品失败");
        }
    }


//    @Override
//    public List<Business> getBusinessByBusinessId(int id) {
//        return businessMapper.getBusinessByBusinessId(id);
//    }
//
//    @Override
//    public List<Products> getProductList() {
//        return productsMapper.getProductsList();
//    }
}
