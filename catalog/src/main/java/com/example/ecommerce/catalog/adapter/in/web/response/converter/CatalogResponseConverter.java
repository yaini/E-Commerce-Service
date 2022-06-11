package com.example.ecommerce.catalog.adapter.in.web.response.converter;

import com.example.ecommerce.catalog.adapter.in.web.response.CatalogResponse;
import com.example.ecommerce.catalog.domain.model.Catalog;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogResponseConverter {

    public static CatalogResponse from(final Catalog data){
        if( data == null ){
            return null;
        }

        return CatalogResponse.builder()
                .id(data.getId())
                .name(data.getName())
                .price(data.getPrice())
                .stock(data.getStock())
                .build();
    }

    public static List<CatalogResponse> from(final List<Catalog> data){
        if(CollectionUtils.isEmpty(data) ){
            return Collections.emptyList();
        }

        return data.stream()
                .map(CatalogResponseConverter::from)
                .collect(Collectors.toUnmodifiableList());
    }
}
