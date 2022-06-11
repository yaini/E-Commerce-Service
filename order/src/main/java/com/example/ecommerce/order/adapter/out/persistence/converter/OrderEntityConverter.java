package com.example.ecommerce.order.adapter.out.persistence.converter;

import com.example.ecommerce.order.adapter.out.persistence.entity.OrderEntity;
import com.example.ecommerce.order.domain.model.Order;

public class OrderEntityConverter {

    public static OrderEntity from(final Order data) {
        if( data == null ){
            return null;
        }

        return OrderEntity.builder()
                .id(data.getId())
                .userId(data.getUserId())
                .comment(data.getComment())
                .build();
    }

    public static Order to(final OrderEntity entity) {
        if( entity == null ){
            return null;
        }

        return Order.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .comment(entity.getComment())
                .build();
    }
}
