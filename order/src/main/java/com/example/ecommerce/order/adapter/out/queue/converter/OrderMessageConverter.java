package com.example.ecommerce.order.adapter.out.queue.converter;

import com.example.ecommerce.order.adapter.out.queue.message.OrderMessage;
import com.example.ecommerce.order.domain.model.Order;

public class OrderMessageConverter {

    public static OrderMessage from(final Order data) {
        return OrderMessage.builder()
                .id(data.getId())
                .userId(data.getUserId())
                .items(OrderItemMessageConverter.from(data.getItems()))
                .build();
    }
}
