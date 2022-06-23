package com.example.ecommerce.order.adapter.in.web.request;

import com.example.ecommerce.order.domain.model.Product;
import lombok.Getter;

import java.util.Collection;

@Getter
public class SaveOrderItemRequest {
    private Long productId;
    private Integer quantity;
    private Collection<Long> promotionIds;
}
