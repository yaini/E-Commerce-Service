package com.example.ecommerce.order.adapter.out.queue.message;

import lombok.Builder;

import java.io.Serializable;
import java.math.BigDecimal;

@Builder
public class OrderItemMessage implements Serializable {
    private Long productId;
    private Integer quantity;
}
