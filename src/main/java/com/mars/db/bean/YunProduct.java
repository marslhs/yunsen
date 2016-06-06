package com.mars.db.bean;

import com.alibaba.fastjson.JSON;

public class YunProduct {
    private Integer productId;

    private String name;

    private Integer capacity;

    private Integer weight;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
    
    public String toString(){
        return JSON.toJSONString(this);
    }
}