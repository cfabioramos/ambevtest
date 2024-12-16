package com.ambev.test.order.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class OrderExtProducts {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orderext_id")
    private OrderExternal orderExt;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private LocalDateTime createdAt;

    public OrderExtProducts() {
        this.createdAt = LocalDateTime.now();
    }

    public OrderExtProducts(Product product, OrderExternal orderExt) {
        this.product = product;
        this.orderExt = orderExt;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderExternal getOrderExt() {
        return orderExt;
    }

    public void setOrderExt(OrderExternal orderExt) {
        this.orderExt = orderExt;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
