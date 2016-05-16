package com.mars.db.bean;

import java.util.Date;

public class OrderInfo {
    private Integer orderId;

    private Integer memberSeq;

    private String remark;

    private Date deliveryDate;

    private String address;

    private Integer productId;

    private Short num;

    private Date orderDate;

    private Integer deliverySeq;

    private Byte status;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getMemberSeq() {
        return memberSeq;
    }

    public void setMemberSeq(Integer memberSeq) {
        this.memberSeq = memberSeq;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Short getNum() {
        return num;
    }

    public void setNum(Short num) {
        this.num = num;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getDeliverySeq() {
        return deliverySeq;
    }

    public void setDeliverySeq(Integer deliverySeq) {
        this.deliverySeq = deliverySeq;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}