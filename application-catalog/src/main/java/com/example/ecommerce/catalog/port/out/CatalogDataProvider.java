package com.example.ecommerce.catalog.port.out;

import com.example.ecommerce.catalog.domain.model.Catalog;
import com.example.ecommerce.catalog.domain.query.SearchCatalogQuery;

import java.util.List;
import java.util.Optional;

public interface CatalogDataProvider {

    Optional<Catalog> findOne(final Long id);

    Catalog save(final Catalog user);

    List<Catalog> findBy(final SearchCatalogQuery query);
}
