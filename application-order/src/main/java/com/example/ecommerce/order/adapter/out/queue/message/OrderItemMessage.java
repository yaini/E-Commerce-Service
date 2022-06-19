package com.example.ecommerce.order.adapter.out.queue.message;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Builder
@Getter
@Setter
public class OrderItemMessage implements Serializable {
    private Long productId;
    private Integer quantity;
}
