package com.example.ecommerce.catalog.port.in;

import com.example.ecommerce.catalog.domain.model.Catalog;
import com.example.ecommerce.catalog.domain.query.GetCatalogQuery;
import com.example.ecommerce.catalog.domain.query.SearchCatalogQuery;

import javax.validation.Valid;
import java.util.List;

public interface SearchCatalogUseCase {
    List<Catalog> execute(final @Valid SearchCatalogQuery query);
}
