package com.ambev.test.order.repository;

import com.ambev.test.order.model.Supplier;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {

    List<Supplier> findByName(String name);

}
