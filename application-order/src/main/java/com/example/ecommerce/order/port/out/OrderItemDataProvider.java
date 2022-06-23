package com.example.ecommerce.order.port.out;

import com.example.ecommerce.order.domain.command.SaveOrderItemCommand;
import com.example.ecommerce.order.domain.model.OrderItem;

import java.util.Collection;

public interface OrderItemDataProvider {

    Collection<OrderItem> save(final Long orderId, final Collection<OrderItem> items);

    OrderItem save(final Long orderId, final OrderItem item);

    Collection<OrderItem> findByOrderId(final Long id);
}
