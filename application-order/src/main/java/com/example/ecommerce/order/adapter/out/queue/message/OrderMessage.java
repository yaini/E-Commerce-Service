package com.example.ecommerce.order.adapter.out.queue.message;

import com.example.ecommerce.order.domain.model.OrderItem;
import lombok.Builder;

import java.io.Serializable;
import java.util.Collection;

@Builder
public class OrderMessage implements Serializable {
    private Long id;
    private Long userId;
    private Collection<OrderItemMessage> items;
}
