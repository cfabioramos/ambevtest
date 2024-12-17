package com.ambev.test.order.dto;

import com.ambev.test.order.model.OrderExternal;

import java.util.Set;
import java.util.stream.Collectors;

public class OrderExternalPostDTO {

    private String description;
    private SupplierPostDTO supplierPostDTO;
    private Set<ProductPostDTO> productPostDTOS;

    public OrderExternalPostDTO(){
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SupplierPostDTO getSupplierDTO() {
        return supplierPostDTO;
    }

    public void setSupplierDTO(SupplierPostDTO supplierPostDTO) {
        this.supplierPostDTO = supplierPostDTO;
    }

    public Set<ProductPostDTO> getProductDTOS() {
        return productPostDTOS;
    }

    public void setProductDTOS(Set<ProductPostDTO> productPostDTOS) {
        this.productPostDTOS = productPostDTOS;
    }

    public OrderExternal toModel() {
        return new OrderExternal(
                        this.description,
                        this.supplierPostDTO.getId(),
                        this.productPostDTOS.stream()
                                .map(ProductPostDTO::getId)
                                .collect(Collectors.toSet()) );
    }

}
