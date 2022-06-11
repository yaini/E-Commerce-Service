package com.example.ecommerce.order.port.out;

import com.example.ecommerce.order.domain.model.Order;
import com.example.ecommerce.order.domain.query.SearchOrderQuery;

import java.util.List;
import java.util.Optional;

public interface OrderDataProvider {

    Optional<Order> findOne(final Long id);

    Order save(final Order user);

    List<Order> findBy(final SearchOrderQuery query);
}
