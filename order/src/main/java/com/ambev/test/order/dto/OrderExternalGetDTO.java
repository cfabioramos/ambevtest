package com.ambev.test.order.dto;

import com.ambev.test.order.model.OrderExternal;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderExternalGetDTO {

    private Long id;
    private String description;
    private LocalDateTime createdAt;
    private SupplierGetDTO supplierGetDTO;
    private Set<ProductGetDTO> productGetDTOS;

    public OrderExternalGetDTO(){
    }

    public OrderExternalGetDTO(OrderExternal model){
        this.id = model.getId();
        this.description = model.getDescription();
        this.createdAt = model.getCreatedAt();
        this.supplierGetDTO = new SupplierGetDTO(model.getSupplier());
        this.productGetDTOS = model.getOrderExtProducts().stream()
                .map(orderExtProducts -> new ProductGetDTO(orderExtProducts.getProduct()))
                .collect(Collectors.toSet());

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public SupplierGetDTO getSupplierDTO() {
        return supplierGetDTO;
    }

    public void setSupplierDTO(SupplierGetDTO supplierGetDTO) {
        this.supplierGetDTO = supplierGetDTO;
    }

    public Set<ProductGetDTO> getProductDTOS() {
        return productGetDTOS;
    }

    public void setProductDTOS(Set<ProductGetDTO> productGetDTOS) {
        this.productGetDTOS = productGetDTOS;
    }

    public Double getTotal() {
        return this.productGetDTOS.stream().mapToDouble(ProductGetDTO::getPrice).sum();
    }

    @Override
    public String toString() {
        return "OrderExternalDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", products=" + productGetDTOS.size() +
                ", supplierDTO=" + supplierGetDTO +
                '}';
    }
}
