package com.example.orderappservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//提供一个无参构造
@NoArgsConstructor
//所有的有参构造
@AllArgsConstructor
public class BusinessForR {
    private Integer business_id;
    private String businessName;
    private String refectory;

    public Integer getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(Integer business_id) {
        this.business_id = business_id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getRefectory() {
        return refectory;
    }

    public void setRefectory(String refectory) {
        this.refectory = refectory;
    }
}
