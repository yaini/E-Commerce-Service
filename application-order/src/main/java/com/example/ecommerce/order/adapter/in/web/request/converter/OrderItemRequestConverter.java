package com.example.ecommerce.order.adapter.in.web.request.converter;

import com.example.ecommerce.order.adapter.in.web.request.SaveOrderItemRequest;
import com.example.ecommerce.order.adapter.in.web.request.SaveOrderRequest;
import com.example.ecommerce.order.domain.command.SaveOrderCommand;
import com.example.ecommerce.order.domain.command.SaveOrderItemCommand;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class OrderItemRequestConverter {

    public static Collection<SaveOrderItemCommand> to(final Collection<SaveOrderItemRequest> request){
        if(CollectionUtils.isEmpty(request)){
            return Collections.emptyList();
        }

        return request.stream()
                .map(OrderItemRequestConverter::to)
                .collect(Collectors.toUnmodifiableList());
    }

    public static SaveOrderItemCommand to(final SaveOrderItemRequest request){
        if( request == null ){
            return null;
        }

        return SaveOrderItemCommand.builder()
                .productId(request.getProductId())
                .quantity(request.getQuantity())
                .build();
    }
}
