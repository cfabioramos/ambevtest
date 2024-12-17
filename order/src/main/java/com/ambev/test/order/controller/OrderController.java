package com.ambev.test.order.controller;

import com.ambev.test.order.dto.OrderExternalGetDTO;
import com.ambev.test.order.dto.OrderExternalPostDTO;
import com.ambev.test.order.service.OrderExternalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderExternalService service;

    @GetMapping("/{id}")
    public void test(@PathVariable Integer id) throws InterruptedException {
        log.info("Id Number {}", id);
    }

    @PostMapping
    public Long save(@RequestBody OrderExternalPostDTO dto) throws InterruptedException {
        log.info("Order to save {}", dto.toString());
        return service.save(dto);
    }

    @GetMapping("/supplier/{supplierId}")
    public Set<OrderExternalGetDTO> fetchFromSupplier(@PathVariable Long supplierId) throws InterruptedException {
        log.info("SupplierId {} to fetch data", supplierId);
        return service.findBySupplier(supplierId);
    }

}
