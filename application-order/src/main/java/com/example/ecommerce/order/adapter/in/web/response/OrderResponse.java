package com.example.ecommerce.order.adapter.in.web.response;

import com.example.ecommerce.order.domain.model.OrderItem;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Collection;

@Getter
@Builder
public class OrderResponse {
    private Long id;
    private Long userId;
    private String comment;
    private Collection<OrderItem> items;
    private BigDecimal totalPrice;
}
