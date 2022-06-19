package com.example.ecommerce.catalog.adapter.in.web.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collection;

@Getter
@Setter
public class BrowseCatalogRequest {
    private Collection<Long> ids;
}
