package com.wss.module.main.bean;

import com.wss.common.base.bean.BaseBean;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Describe：订单
 * Created by 吴天强 on 2018/10/23.
 */
@Getter
@Setter
public class Order extends BaseBean {

    private String orderId;
    private String orderDate;
    private int orderState;// 1待支付 2待发货 3待确认 4已失效
    private String orderTotal;
    private List<Goods> goodsList;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public String getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(String orderTotal) {
        this.orderTotal = orderTotal;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }
}


