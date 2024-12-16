package com.ambev.test.order.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class OrderExternal {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String description;

    @OneToMany(mappedBy = "orderExt", fetch = FetchType.EAGER)
    private Set<OrderExtProducts> orderExtProducts;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    private LocalDateTime createdAt;

    protected OrderExternal() {}

    public OrderExternal(String description, Supplier supplier/*, Set<Product> products*/) {
        this.description = description;
        this.supplier = supplier;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Set<OrderExtProducts> getOrderExtProducts() {
        return orderExtProducts;
    }

    public void setOrderExtProducts(Set<OrderExtProducts> orderExtProducts) {
        this.orderExtProducts = orderExtProducts;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "OrderExternal{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", supplier=" + supplier +
                ", createdAt=" + createdAt +
                '}';
    }
}
