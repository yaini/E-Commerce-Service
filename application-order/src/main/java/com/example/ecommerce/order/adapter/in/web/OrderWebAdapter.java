package com.example.ecommerce.order.adapter.in.web;

import com.example.ecommerce.order.adapter.in.web.request.BrowseOrderRequest;
import com.example.ecommerce.order.adapter.in.web.request.SaveOrderRequest;
import com.example.ecommerce.order.adapter.in.web.request.converter.OrderRequestConverter;
import com.example.ecommerce.order.adapter.in.web.response.OrderResponse;
import com.example.ecommerce.order.adapter.in.web.response.converter.OrderResponseConverter;
import com.example.ecommerce.order.domain.model.Order;
import com.example.ecommerce.order.domain.query.GetOrderQuery;
import com.example.ecommerce.order.domain.query.SearchOrderQuery;
import com.example.ecommerce.order.port.in.GetOrderUseCase;
import com.example.ecommerce.order.port.in.SaveOrderUseCase;
import com.example.ecommerce.order.port.in.SearchOrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class OrderWebAdapter {

    private final SearchOrderUseCase searchUseCase;
    private final GetOrderUseCase getUseCase;
    private final SaveOrderUseCase saveUseCase;

    public OrderResponse add(final SaveOrderRequest request){
        Order user = saveUseCase.execute(OrderRequestConverter.to(request));
        return OrderResponseConverter.from(user);
    }

    public OrderResponse read(final Long id) {
        return OrderResponseConverter.from(getUseCase.execute(new GetOrderQuery(id)));
    }

    public List<OrderResponse> browse(final BrowseOrderRequest request) {
        return OrderResponseConverter.from(searchUseCase.execute(new SearchOrderQuery()));
    }
}
