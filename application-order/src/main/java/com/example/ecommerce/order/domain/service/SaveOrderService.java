package com.example.ecommerce.order.domain.service;

import com.example.ecommerce.order.domain.command.SaveOrderCommand;
import com.example.ecommerce.order.domain.model.Order;
import com.example.ecommerce.order.domain.model.OrderItem;
import com.example.ecommerce.order.domain.model.Product;
import com.example.ecommerce.order.port.in.SaveOrderUseCase;
import com.example.ecommerce.order.port.out.OrderDataProvider;
import com.example.ecommerce.order.port.out.OrderEventDataProvider;
import com.example.ecommerce.order.port.out.OrderItemDataProvider;
import com.example.ecommerce.order.port.out.ProductDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Map;

@Validated
@Transactional
@RequiredArgsConstructor
@Service
public class SaveOrderService implements SaveOrderUseCase {

    private final OrderDataProvider dataProvider;
    private final OrderItemDataProvider itemDataProvider;

    private final OrderEventDataProvider eventDataProvider;

    @Override
    public Order execute(final @Valid SaveOrderCommand command) {
        Order data = this.saveAssociations(dataProvider.save(command.getOrder()), command);

        eventDataProvider.publish(data);
        return dataProvider.findOne(data.getId()).orElseThrow();
    }

    private Order saveAssociations(final Order data, final @Valid SaveOrderCommand command){
        data.bind(itemDataProvider.save(data.getId(), command.getItems()));

        return data;
    }
}
