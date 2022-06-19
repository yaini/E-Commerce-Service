package com.example.ecommerce.order.port.in;

import com.example.ecommerce.order.domain.command.SaveOrderCommand;
import com.example.ecommerce.order.domain.model.Order;

import javax.validation.Valid;

public interface SaveOrderUseCase {

    Order execute(final @Valid SaveOrderCommand command);
}
