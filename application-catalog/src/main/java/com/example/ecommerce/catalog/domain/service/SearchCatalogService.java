package com.example.ecommerce.catalog.domain.service;

import com.example.ecommerce.catalog.domain.model.Catalog;
import com.example.ecommerce.catalog.domain.query.SearchCatalogQuery;
import com.example.ecommerce.catalog.port.in.SearchCatalogUseCase;
import com.example.ecommerce.catalog.port.out.CatalogDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
@Transactional
@RequiredArgsConstructor
@Service
public class SearchCatalogService implements SearchCatalogUseCase {

    private final CatalogDataProvider dataProvider;

    @Override
    public List<Catalog> execute(final @Valid SearchCatalogQuery query) {
        return dataProvider.findBy(query);
    }
}
