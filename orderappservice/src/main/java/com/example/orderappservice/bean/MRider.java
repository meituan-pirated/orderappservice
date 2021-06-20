package com.example.orderappservice.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MRider {
    private Integer rider_id;
    private String name;
    private String phoneNumber;
    private String password;
    private String riderState;
    private Integer totalOrder;

    public Integer getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(Integer totalOrder) {
        this.totalOrder = totalOrder;
    }

    public Integer getRider_id() {
        return rider_id;
    }

    public void setRider_id(Integer rider_id) {
        this.rider_id = rider_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRiderState() {
        return riderState;
    }

    public void setRiderState(String riderState) {
        this.riderState = riderState;
    }
}
