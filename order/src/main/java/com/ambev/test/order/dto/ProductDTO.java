package com.ambev.test.order.dto;

import com.ambev.test.order.model.Product;

public class ProductDTO {

    private Long id;

    private String name;

    private Double price;

    public ProductDTO() {}

    public ProductDTO(Product model) {
        this.id = model.getId();
        this.name = model.getName();
        this.price = model.getPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
