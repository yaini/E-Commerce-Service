package com.example.ecommerce.order.port.out;

import com.example.ecommerce.order.domain.model.Order;

public interface OrderEventDataProvider {

    void publish(final Order data);
}
