package com.ambev.test.order.service;

import com.ambev.test.order.dto.OrderExternalDTO;
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

    public Long save(OrderExternal externalOrder) {
        return this.repository.save(externalOrder).getId();
    }

    public Set<OrderExternalDTO> findBySupplier(Long supplierId) {
        return this.repository.findBySupplier(new Supplier(supplierId)).stream()
                .map(OrderExternalDTO::new).collect(Collectors.toSet());
    }

}
