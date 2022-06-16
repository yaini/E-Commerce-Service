package com.example.ecommerce.catalog.adapter.in.queue.message;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.Collection;

@Getter
@Builder
public class OrderMessage implements Serializable {
    private Long id;
    private Long userId;
    private Collection<OrderItemMessage> items;
}
