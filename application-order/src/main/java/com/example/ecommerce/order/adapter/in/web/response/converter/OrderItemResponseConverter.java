package com.example.ecommerce.order.adapter.in.web.response.converter;

import com.example.ecommerce.order.adapter.in.web.response.OrderItemResponse;
import com.example.ecommerce.order.adapter.in.web.response.OrderResponse;
import com.example.ecommerce.order.domain.model.Order;
import com.example.ecommerce.order.domain.model.OrderItem;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OrderItemResponseConverter {

    public static OrderItemResponse from(final OrderItem data){
        if( data == null ){
            return null;
        }

        return OrderItemResponse.builder()
                .id(data.getId())
                .productId(data.getProduct().getId())
                .name(data.getProduct().getName())
                .price(data.getProduct().getPrice())
                .quantity(data.getQuantity())
                .build();
    }

    public static Collection<OrderItemResponse> from(final Collection<OrderItem> data){
        if(CollectionUtils.isEmpty(data) ){
            return Collections.emptyList();
        }

        return data.stream()
                .map(OrderItemResponseConverter::from)
                .collect(Collectors.toUnmodifiableList());
    }
}
