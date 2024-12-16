package com.ambev.test.order.repository;

import com.ambev.test.order.model.OrderExtProducts;
import org.springframework.data.repository.CrudRepository;

public interface OrderExtProductsRepository extends CrudRepository<OrderExtProducts, Long> {
}
