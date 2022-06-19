package com.example.ecommerce.order.adapter.in.web.response.converter;

import com.example.ecommerce.order.adapter.in.web.response.OrderResponse;
import com.example.ecommerce.order.domain.model.Order;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OrderResponseConverter {

    public static OrderResponse from(final Order data){
        if( data == null ){
            return null;
        }

        return OrderResponse.builder()
                .id(data.getId())
                .userId(data.getUserId())
                .comment(data.getComment())
                .totalPrice(data.getTotalPrice())
                .items(OrderItemResponseConverter.from(data.getItems()))
                .build();
    }

    public static List<OrderResponse> from(final List<Order> data){
        if(CollectionUtils.isEmpty(data)){
            return Collections.emptyList();
        }

        return data.stream()
                .map(OrderResponseConverter::from)
                .collect(Collectors.toUnmodifiableList());
    }
}
