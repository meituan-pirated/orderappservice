package com.example.orderappservice.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductBriefForM {
    private Integer product_id;
    private String productName;
    private int salePrice;
    private String image;

}
