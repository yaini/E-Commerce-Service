package com.example.ecommerce.catalog.adapter.in.queue.message;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class OrderItemMessage implements Serializable {
    private Long productId;
    private Integer quantity;
}
