package com.ambev.test.order.repository;

import com.ambev.test.order.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByName(String name);

}
