package com.example.ecommerce.catalog.domain.query;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;

@AllArgsConstructor
@Getter
public class SearchCatalogQuery {
    Collection<Long> ids;
}
