package com.example.orderappservice.pojo;

public class OrderDetailsForU {
    private Order order;
    /*包括了
    private int order_id;//订单编号
    private int user_id; //用户编号
    private int merchant_id; //商家编号
    private Address address; //地址信息
            *//*包扩了
            private String ReceiveName;//收件人
            private String Sex;        //性别
            private String ReceivePhone;    //联系电话
            private String AddressName;    //收货地址
           *//*
    private String OrderNote; //商品备注
    private String OrderState;//订单状态：待处理，进行中，已完成，已取消
    private String OrderTime;*/
    private BusinessForR businessInfo;
    private Rider rider;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public BusinessForR getBusinessInfo() {
        return businessInfo;
    }

    public void setBusinessInfo(BusinessForR businessInfo) {
        this.businessInfo = businessInfo;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }
}
