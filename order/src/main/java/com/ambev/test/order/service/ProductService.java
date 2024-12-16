package com.ambev.test.order.service;

import com.ambev.test.order.errorHandling.ItemNotFoundException;
import com.ambev.test.order.model.Product;
import com.ambev.test.order.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product findById(Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

    public Iterable<Product> findAll() {
        return this.repository.findAll();
    }

    public Long save(Product product) {
        return this.repository.save(product).getId();
    }

    public Iterable<Product> findByName(String name) {
        return this.repository.findByName(name);
    }

}
