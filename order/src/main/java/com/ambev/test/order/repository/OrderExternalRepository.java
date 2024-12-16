package com.ambev.test.order.repository;

import com.ambev.test.order.model.OrderExternal;
import com.ambev.test.order.model.Supplier;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface OrderExternalRepository extends CrudRepository<OrderExternal, Long> {

    Set<OrderExternal> findBySupplier(Supplier supplier);

}
