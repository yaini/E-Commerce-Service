package com.example.ecommerce.order.adapter.in.web.response;

import com.example.ecommerce.order.domain.model.Product;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Builder
public class OrderItemResponse implements Serializable {
    private Long id;
    private Long productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
