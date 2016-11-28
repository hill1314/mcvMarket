package com.hull.module;

import com.hull.entity.OrderItem;
import org.springframework.core.annotation.Order;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class MasterOrderVo {

    private String orderNo;     // 订单号
    private Date createTime;    //创建时间
    private Date payTime;       //支付时间
    private String userId;      //用户ID
    private BigDecimal totalPrice;  //订单计算总价
    private BigDecimal realyPrice;  //实际结算价格
    private BigDecimal payPrice;    //初始支付金额
    private String status;          //订单状态
    private String note;        //备注信息

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    private List<OrderItem> orderItems;

    public enum OrderStatus {
        INIT("初始化", "1"), NO_PAY("未支付", "2"), PART_PAY("部分支付", "3"), PAYED("已支付", "4");

        private String desc ;
        private String value ;

        OrderStatus(String desc, String index) {
            this.desc = desc ;
            this.value = value ;
        }

        public String getDesc() {
            return desc;
        }
        public void setDesc(String desc) {
            this.desc = desc;
        }
        public String getValue() {
            return value;
        }
        public void setValue(String value) {
            this.value = value;
        }

    }

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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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