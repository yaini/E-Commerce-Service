package com.example.ecommerce.catalog.adapter.in.web.response;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class CatalogResponse {
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer stock;
}
