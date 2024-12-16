package com.ambev.test.order.dto;

import com.ambev.test.order.model.OrderExternal;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderExternalDTO {

    private Long id;
    private String description;
    private LocalDateTime createdAt;
    private SupplierDTO supplierDTO;
    private Set<ProductDTO> productDTOS;

    public OrderExternalDTO(){
    }

    public OrderExternalDTO(OrderExternal model){
        this.id = model.getId();
        this.description = model.getDescription();
        this.createdAt = model.getCreatedAt();
        this.supplierDTO = new SupplierDTO(model.getSupplier());
        this.productDTOS = model.getOrderExtProducts().stream()
                .map(orderExtProducts -> new ProductDTO(orderExtProducts.getProduct()))
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

    public SupplierDTO getSupplierDTO() {
        return supplierDTO;
    }

    public void setSupplierDTO(SupplierDTO supplierDTO) {
        this.supplierDTO = supplierDTO;
    }

    public Set<ProductDTO> getProductDTOS() {
        return productDTOS;
    }

    public void setProductDTOS(Set<ProductDTO> productDTOS) {
        this.productDTOS = productDTOS;
    }

    public Double getTotal() {
        return this.productDTOS.stream().mapToDouble(ProductDTO::getPrice).sum();
    }

    @Override
    public String toString() {
        return "OrderExternalDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", products=" + productDTOS.size() +
                ", supplierDTO=" + supplierDTO +
                '}';
    }
}
