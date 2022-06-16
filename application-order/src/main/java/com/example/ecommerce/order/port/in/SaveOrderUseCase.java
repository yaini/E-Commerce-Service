package com.example.ecommerce.order.port.in;

import com.example.ecommerce.order.domain.command.SaveOrderCommand;
import com.example.ecommerce.order.domain.model.Order;

public interface SaveOrderUseCase {

    Order execute(final SaveOrderCommand command);
}
