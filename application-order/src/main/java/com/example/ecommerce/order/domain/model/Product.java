package com.example.ecommerce.order.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
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
