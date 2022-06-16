package com.example.ecommerce.catalog.domain.service;

import com.example.ecommerce.catalog.domain.model.Catalog;
import com.example.ecommerce.catalog.domain.query.GetCatalogQuery;
import com.example.ecommerce.catalog.port.in.GetCatalogUseCase;
import com.example.ecommerce.catalog.port.out.CatalogDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class GetCatalogService implements GetCatalogUseCase {

    private final CatalogDataProvider dataProvider;

    @Override
    public Catalog execute(final @Valid GetCatalogQuery query) {
        return dataProvider.findOne(query.getId())
                .orElseThrow();
    }
}
