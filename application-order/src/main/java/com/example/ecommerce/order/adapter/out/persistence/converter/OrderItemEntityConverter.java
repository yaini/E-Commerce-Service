package com.example.ecommerce.order.adapter.out.persistence.converter;

import com.example.ecommerce.order.adapter.out.persistence.entity.OrderEntity;
import com.example.ecommerce.order.adapter.out.persistence.entity.OrderItemEntity;
import com.example.ecommerce.order.domain.model.Order;
import com.example.ecommerce.order.domain.model.OrderItem;
import com.example.ecommerce.order.domain.model.Product;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class OrderItemEntityConverter {

    public static OrderItemEntity from(final Long orderId, final OrderItem data) {
        if( data == null ){
            return null;
        }

        return OrderItemEntity.builder()
                .id(data.getId())
                .orderId(orderId)
                .productId(data.getProduct().getId())
                .quantity(data.getQuantity())
                .build();
    }

    public static OrderItem to(final OrderItemEntity entity) {
        if( entity == null ){
            return null;
        }

        return OrderItem.builder()
                .id(entity.getId())
                .product(new Product(entity.getProductId()))
                .quantity(entity.getQuantity())
                .build();
    }

    public static Collection<OrderItemEntity> from(final Long orderId, final Collection<OrderItem> data) {
        if(CollectionUtils.isEmpty(data)){
            return Collections.emptyList();
        }

        return data.stream()
                .map( v -> OrderItemEntityConverter.from(orderId, v))
                .collect(Collectors.toUnmodifiableList());
    }

    public static Collection<OrderItem> to(final Collection<OrderItemEntity> entity) {
        if(CollectionUtils.isEmpty(entity)){
            return Collections.emptyList();
        }

        return entity.stream()
                .map(OrderItemEntityConverter::to)
                .collect(Collectors.toUnmodifiableList());
    }

}
