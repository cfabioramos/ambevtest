package com.ambev.test.order.dto;

import com.ambev.test.order.model.Supplier;

public class SupplierDTO {

    private Long id;
    private String name;

    public SupplierDTO(){
    }

    public SupplierDTO(Supplier model){
        this.id = model.getId();
        this.name = model.getName();
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

    @Override
    public String toString() {
        return String.format("Supplier [id=%d, Name='%s']", id, name);
    }
}
