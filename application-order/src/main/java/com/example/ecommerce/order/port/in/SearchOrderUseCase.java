package com.example.ecommerce.order.port.in;

import com.example.ecommerce.order.domain.model.Order;
import com.example.ecommerce.order.domain.query.SearchOrderQuery;

import javax.validation.Valid;
import java.util.List;

public interface SearchOrderUseCase {
    List<Order> execute(final @Valid SearchOrderQuery query);
}
