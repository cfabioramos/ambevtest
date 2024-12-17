package com.ambev.test.order.service;

import com.ambev.test.order.dto.OrderExternalGetDTO;
import com.ambev.test.order.dto.OrderExternalPostDTO;
import com.ambev.test.order.errorHandling.ItemNotFoundException;
import com.ambev.test.order.model.OrderExternal;
import com.ambev.test.order.model.Supplier;
import com.ambev.test.order.repository.OrderExternalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderExternalService {

    @Autowired
    private OrderExternalRepository repository;

    public OrderExternal findById(Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

    public Long save(OrderExternalPostDTO dto) {
        return this.repository.save(dto.toModel()).getId();
    }

    public Set<OrderExternalGetDTO> findBySupplier(Long supplierId) {
        return this.repository.findBySupplier(new Supplier(supplierId)).stream()
                .map(OrderExternalGetDTO::new).collect(Collectors.toSet());
    }

}
