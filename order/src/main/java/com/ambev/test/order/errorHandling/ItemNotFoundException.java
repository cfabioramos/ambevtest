package com.ambev.test.order.errorHandling;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(Long id) {
        super(String.format("Item id %d not found.", id));
    }
}
