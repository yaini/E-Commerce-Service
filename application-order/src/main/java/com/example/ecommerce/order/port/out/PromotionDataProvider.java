package com.example.ecommerce.order.port.out;

import com.example.ecommerce.order.domain.model.OrderItem;

public interface PromotionDataProvider {
    OrderItem apply(final OrderItem orderItem);
}
