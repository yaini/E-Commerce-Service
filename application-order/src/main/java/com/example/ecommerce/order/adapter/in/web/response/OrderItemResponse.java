package com.example.ecommerce.order.adapter.in.web.response;

import com.example.ecommerce.order.domain.model.Product;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public class OrderItemResponse {
    private Long id;
    private Long productId;
    private String name;
    private BigDecimal price;
    private Integer stock;
    private Integer quantity;
}
