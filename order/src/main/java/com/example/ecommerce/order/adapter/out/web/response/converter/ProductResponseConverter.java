package com.example.ecommerce.order.adapter.out.web.response.converter;

import com.example.ecommerce.order.adapter.out.web.response.ProductResponse;
import com.example.ecommerce.order.domain.model.Product;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class ProductResponseConverter {

    public static Product to(final ProductResponse response){
        if( response == null ){
            return null;
        }

        return Product.builder()
                .id(response.getId())
                .name(response.getName())
                .price(response.getPrice())
                .stock(response.getStock())
                .build();
    }

    public static Collection<Product> to(final Collection<ProductResponse> response){
        if(CollectionUtils.isEmpty(response) ){
            return Collections.emptyList();
        }

        return response.stream()
                .map(ProductResponseConverter::to)
                .collect(Collectors.toUnmodifiableList());
    }
}
