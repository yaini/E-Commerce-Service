package com.example.ecommerce.order.domain.service;

import com.example.ecommerce.order.domain.command.SaveOrderCommand;
import com.example.ecommerce.order.domain.model.Order;
import com.example.ecommerce.order.domain.model.OrderItem;
import com.example.ecommerce.order.domain.model.Product;
import com.example.ecommerce.order.port.in.SaveOrderUseCase;
import com.example.ecommerce.order.port.out.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Validated
@Transactional
@RequiredArgsConstructor
@Service
public class SaveOrderService implements SaveOrderUseCase {

    private final OrderDataProvider dataProvider;
    private final OrderItemDataProvider itemDataProvider;

    private final OrderEventDataProvider eventDataProvider;
    private final ProductDataProvider productDataProvider;
    private final PromotionDataProvider promotionDataProvider;

    @Override
    public Order execute(final @Valid SaveOrderCommand command) {
        Order data = this.saveAssociations(dataProvider.save(command.getOrder()), command);

        eventDataProvider.publish(data);
        return dataProvider.findOne(data.getId()).orElseThrow();
    }

    private Order saveAssociations(final Order data, final @Valid SaveOrderCommand command){
        Map<Long, Product> products = productDataProvider.findBy(data.getProductIds()).stream()
                .collect(HashMap::new, (m, v) -> m.put(v.getId(), v), HashMap::putAll);

        Collection<OrderItem> items = command.getItems().stream()
                .peek( v -> v.bind(products.getOrDefault(v.getProduct().getId(), Product.EMPTY)))
                .map(promotionDataProvider::apply)
                .map( v -> itemDataProvider.save(data.getId(), v))
                .collect(Collectors.toUnmodifiableList());

        return data.toBuilder()
                .items(items)
                .build();
    }
}
