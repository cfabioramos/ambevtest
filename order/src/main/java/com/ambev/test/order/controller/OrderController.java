package com.ambev.test.order.controller;

import com.ambev.test.order.dto.OrderExternalDTO;
import com.ambev.test.order.service.OrderExternalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderExternalService service;

    @GetMapping("/{id}")
    public void block(@PathVariable Integer id) throws InterruptedException {
        log.info("Id Number {}", id);
    }

    @GetMapping("/supplier/{supplierId}")
    public Set<OrderExternalDTO> fetchFromSupplier(@PathVariable Long supplierId) throws InterruptedException {
        log.info("SupplierId {} to fetch data", supplierId);
        return service.findBySupplier(supplierId);
    }

}
