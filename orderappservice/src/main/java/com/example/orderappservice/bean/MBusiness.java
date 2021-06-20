package com.example.orderappservice.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MBusiness{
    private Integer business_id;
    private String businessName;
    private String refectory;
    private String descriptions;
    private String businessState;
    private Integer totalOrder;

    public Integer getBusiness_id() {
        return business_id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public String getRefectory() {
        return refectory;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public String getBusinessState() {
        return businessState;
    }

    public void setBusiness_id(Integer business_id) {
        this.business_id = business_id;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public void setRefectory(String refectory) {
        this.refectory = refectory;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void setBusinessState(String businessState) {
        this.businessState = businessState;
    }

    public Integer getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(Integer totalOrder) {
        this.totalOrder = totalOrder;
    }
}
