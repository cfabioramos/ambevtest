package com.ambev.test.order.model;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private Double price;

    public Product() {}

    public Product(Long id) {
        this.id = id;
    }

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
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

    @Override
    public String toString() {
        return String.format(
                "Product [id=%d, Name='%s', Price='%s']",
                id, name, price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Product product))
            return false;

        return Objects.equals(this.id, product.id) && Objects.equals(this.name, product.name);
    }
}
