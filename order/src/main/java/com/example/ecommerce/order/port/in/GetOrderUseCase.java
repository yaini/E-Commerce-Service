package com.example.ecommerce.order.port.in;

import com.example.ecommerce.order.domain.model.Order;
import com.example.ecommerce.order.domain.query.GetOrderQuery;

import javax.validation.Valid;

public interface GetOrderUseCase {

    Order execute(final @Valid GetOrderQuery query);
}
