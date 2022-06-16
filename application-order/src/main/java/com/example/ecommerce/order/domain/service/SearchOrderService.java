package com.example.ecommerce.order.domain.service;

import com.example.ecommerce.order.domain.model.Order;
import com.example.ecommerce.order.domain.query.SearchOrderQuery;
import com.example.ecommerce.order.port.in.SearchOrderUseCase;
import com.example.ecommerce.order.port.out.OrderDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
@Transactional
@RequiredArgsConstructor
@Service
public class SearchOrderService implements SearchOrderUseCase {

    private final OrderDataProvider dataProvider;

    @Override
    public List<Order> execute(final @Valid SearchOrderQuery query) {
        // TODO
        return dataProvider.findBy(query);
    }
}
