package com.example.ecommerce.order.adapter.out.persistence;

import com.example.ecommerce.order.adapter.out.persistence.converter.OrderEntityConverter;
import com.example.ecommerce.order.adapter.out.persistence.entity.OrderEntity;
import com.example.ecommerce.order.adapter.out.persistence.repository.OrderRepository;
import com.example.ecommerce.order.domain.model.Order;
import com.example.ecommerce.order.domain.query.SearchOrderQuery;
import com.example.ecommerce.order.port.out.OrderDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class OrderDataPersistenceAdapter implements OrderDataProvider {

    private final OrderRepository repository;

    @Override
    public Optional<Order> findOne(Long id) {
        return repository.findById(id).map(OrderEntityConverter::to);
    }

    @Override
    public Order save(final Order data) {
        if( data == null ){
            return null;
        }

        OrderEntity entity = OrderEntityConverter.from(data);
        return OrderEntityConverter.to(repository.save(entity));
    }

    @Override
    public List<Order> findBy(final SearchOrderQuery query) {
        if( query == null ){
            return null;
        }

        return repository.findAll().stream()
                .map(OrderEntityConverter::to)
                .collect(Collectors.toUnmodifiableList());
    }
}
