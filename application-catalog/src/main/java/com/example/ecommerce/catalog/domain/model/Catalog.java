package com.example.ecommerce.catalog.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Catalog {
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer stock;
}
