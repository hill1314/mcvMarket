package com.hull.entity;

import java.math.BigDecimal;
import java.util.Date;

public class MasterOrder {

    private String orderNo;     // 订单号
    private Date createTime;    //创建时间
    private Date payTime;       //支付时间
    private String userId;      //用户ID
    private BigDecimal totalPrice;  //订单计算总价
    private BigDecimal realyPrice;  //实际结算价格
    private BigDecimal payPrice;    //初始支付金额
    private String status;          //订单状态

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getRealyPrice() {
        return realyPrice;
    }

    public void setRealyPrice(BigDecimal realyPrice) {
        this.realyPrice = realyPrice;
    }

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}