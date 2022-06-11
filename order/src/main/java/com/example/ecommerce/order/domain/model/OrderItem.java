package com.example.ecommerce.order.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class OrderItem {
    private Long id;
    private Product product;
    private Integer quantity;

    public void bind(final Product product){
        this.product = product;
    }
}
