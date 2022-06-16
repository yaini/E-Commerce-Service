package com.example.ecommerce.order.port.out;

import com.example.ecommerce.order.domain.model.Product;

import java.util.Collection;
import java.util.Map;

public interface ProductDataProvider {
    Collection<Product> findBy(final Collection<Long> productIds);
}
