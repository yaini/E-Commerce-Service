package com.example.ecommerce.order.adapter.out.persistence;

import com.example.ecommerce.order.adapter.out.persistence.converter.OrderItemEntityConverter;
import com.example.ecommerce.order.adapter.out.persistence.entity.OrderItemEntity;
import com.example.ecommerce.order.adapter.out.persistence.repository.OrderItemRepository;
import com.example.ecommerce.order.domain.command.SaveOrderItemCommand;
import com.example.ecommerce.order.domain.model.OrderItem;
import com.example.ecommerce.order.port.out.OrderItemDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;

@RequiredArgsConstructor
@Component
public class OrderItemDataPersistenceAdapter implements OrderItemDataProvider {

    private final OrderItemRepository repository;

    @Override
    public Collection<OrderItem> save(final Long orderId, final Collection<OrderItem> items) {
        Collection<OrderItemEntity> entities = OrderItemEntityConverter.from(orderId, items);

        return OrderItemEntityConverter.to(repository.saveAll(entities));
    }

    @Override
    public Collection<OrderItem> findByOrderId(final Long orderId) {
        return OrderItemEntityConverter.to(repository.findByOrderId(orderId));
    }
}
