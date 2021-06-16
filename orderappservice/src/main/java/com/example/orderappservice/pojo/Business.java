package com.example.orderappservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
//提供一个无参构造
@NoArgsConstructor
//所有的有参构造
@AllArgsConstructor
public class Business {
    private Integer business_id;
    private String businessName;
    private String refectory;
    private String descriptions;
    private int businessImage;

    //一对多的关系，为一的一方
    private List<Products> productsList;

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

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getBusinessImage() {
        return businessImage;
    }

    public void setBusinessImage(int businessImage) {
        this.businessImage = businessImage;
    }

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }
}
