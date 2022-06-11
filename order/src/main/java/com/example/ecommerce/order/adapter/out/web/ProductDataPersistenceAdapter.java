package com.example.ecommerce.order.adapter.out.web;

import com.example.ecommerce.order.domain.model.Product;
import com.example.ecommerce.order.port.out.ProductDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Component
public class ProductDataPersistenceAdapter implements ProductDataProvider {
    @Override
    public Collection<Product> findBy(Collection<Long> productIds) {
        // TODO
        return List.of(new Product(1L));
    }
}
