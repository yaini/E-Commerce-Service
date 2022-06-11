package com.example.ecommerce.catalog.port.in;

import com.example.ecommerce.catalog.domain.model.Catalog;
import com.example.ecommerce.catalog.domain.query.GetCatalogQuery;

import javax.validation.Valid;

public interface GetCatalogUseCase {

    Catalog execute(final @Valid GetCatalogQuery query);
}
