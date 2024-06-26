package com.sportyshoes.entity;

import java.util.Date;

public class Order {
    private Long id;
    private Long userId;
    private Long productId;
    private Date orderDate;

    // Constructors, getters, and setters

    public Order() {}

    public Order(Long id, Long userId, Long productId, Date orderDate) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.orderDate = orderDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}