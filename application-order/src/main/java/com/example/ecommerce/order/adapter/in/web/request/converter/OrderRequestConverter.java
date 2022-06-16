package com.example.ecommerce.order.adapter.in.web.request.converter;

import com.example.ecommerce.order.adapter.in.web.request.SaveOrderRequest;
import com.example.ecommerce.order.domain.command.SaveOrderCommand;

public class OrderRequestConverter {

    public static SaveOrderCommand to(final SaveOrderRequest request){
        if( request == null ){
            return null;
        }

        return SaveOrderCommand.builder()
                .userId(request.getUserId())
                .comment(request.getComment())
                .items(OrderItemRequestConverter.to(request.getItems()))
                .build();
    }
}
