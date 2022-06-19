package com.example.ecommerce.order.domain.service;

import com.example.ecommerce.order.domain.model.Order;
import com.example.ecommerce.order.domain.model.Product;
import com.example.ecommerce.order.domain.query.GetOrderQuery;
import com.example.ecommerce.order.port.in.GetOrderUseCase;
import com.example.ecommerce.order.port.out.OrderDataProvider;
import com.example.ecommerce.order.port.out.OrderItemDataProvider;
import com.example.ecommerce.order.port.out.ProductDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Validated
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class GetOrderService implements GetOrderUseCase {

    private final OrderDataProvider dataProvider;
    private final OrderItemDataProvider itemDataProvider;
    private final ProductDataProvider productDataProvider;

    @Override
    public Order execute(final @Valid GetOrderQuery query) {
        Order order = dataProvider.findOne(query.getId()).orElseThrow();

        return this.bindOrderItems(order);
    }

    private Order bindOrderItems(final Order data){
        data.bind(itemDataProvider.findByOrderId(data.getId()));

        return this.bindProduct(data);
    }

    private Order bindProduct(final Order data){
        Map<Long, Product> products = productDataProvider.findBy(data.getProductIds()).stream()
                .collect(HashMap::new, (m,v) -> m.put(v.getId(), v), HashMap::putAll);

        data.getItems().forEach( v -> v.bind(products.get(v.getProduct().getId())));
        return data;
    }
}
