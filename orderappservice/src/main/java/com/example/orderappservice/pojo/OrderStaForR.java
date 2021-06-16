package com.example.orderappservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderStaForR {
    private Integer quantity;//今天的单数
    private Integer income;//今日收入
    private List<OrderForR> finishedOrderList;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    public List<OrderForR> getFinishedOrderList() {
        return finishedOrderList;
    }

    public void setFinishedOrderList(List<OrderForR> finishedOrderList) {
        this.finishedOrderList = finishedOrderList;
    }
}
