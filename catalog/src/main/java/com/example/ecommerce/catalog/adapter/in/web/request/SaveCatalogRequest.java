package com.example.ecommerce.catalog.adapter.in.web.request;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class SaveCatalogRequest {
    private String name;
    private BigDecimal price;
    private Integer stock;
}
