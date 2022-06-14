package com.example.ecommerce.order.adapter.out.queue.converter;

import com.example.ecommerce.order.adapter.out.queue.message.OrderItemMessage;
import com.example.ecommerce.order.domain.model.OrderItem;

import java.util.Collection;
import java.util.stream.Collectors;

public class OrderItemMessageConverter {
    public static Collection<OrderItemMessage> from(final Collection<OrderItem> data) {
        return data.stream()
                .map(OrderItemMessageConverter::from)
                .collect(Collectors.toUnmodifiableList());
    }

    public static OrderItemMessage from(final OrderItem data) {
        return OrderItemMessage.builder()
                .productId(data.getProduct().getId())
                .quantity(data.getQuantity())
                .build();
    }
}
