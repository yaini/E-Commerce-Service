package com.example.ecommerce.order.domain.model;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer stock;

    public Product(final Long id){
        this.id = id;
    }
}
