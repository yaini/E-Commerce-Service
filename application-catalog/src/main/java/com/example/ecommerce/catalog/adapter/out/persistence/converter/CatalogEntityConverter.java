package com.example.ecommerce.catalog.adapter.out.persistence.converter;

import com.example.ecommerce.catalog.adapter.out.persistence.entity.CatalogEntity;
import com.example.ecommerce.catalog.domain.model.Catalog;

public class CatalogEntityConverter {

    public static CatalogEntity from(final Catalog data) {
        return CatalogEntity.builder()
                .id(data.getId())
                .name(data.getName())
                .price(data.getPrice())
                .stock(data.getStock())
                .build();
    }

    public static Catalog to(final CatalogEntity entity) {
        return Catalog.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .stock(entity.getStock())
                .build();
    }
}
