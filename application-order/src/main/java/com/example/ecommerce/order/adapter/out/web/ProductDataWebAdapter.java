package com.example.ecommerce.order.adapter.out.web;

import com.example.ecommerce.order.adapter.out.web.client.ProductWebClient;
import com.example.ecommerce.order.adapter.out.web.response.converter.ProductResponseConverter;
import com.example.ecommerce.order.domain.model.Product;
import com.example.ecommerce.order.port.out.ProductDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;

@RequiredArgsConstructor
@Component
public class ProductDataWebAdapter implements ProductDataProvider {

    private final ProductWebClient client;

    @Override
    public Collection<Product> findBy(final Collection<Long> productIds) {
        if(CollectionUtils.isEmpty(productIds)){
            return Collections.emptyList();
        }

        return ProductResponseConverter.to(client.findBy(productIds));
    }
}
