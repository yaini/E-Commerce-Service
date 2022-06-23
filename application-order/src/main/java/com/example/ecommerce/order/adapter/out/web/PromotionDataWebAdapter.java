package com.example.ecommerce.order.adapter.out.web;

import com.example.ecommerce.order.adapter.out.web.client.ProductWebClient;
import com.example.ecommerce.order.adapter.out.web.client.PromotionWebClient;
import com.example.ecommerce.order.adapter.out.web.request.PromotionRequest;
import com.example.ecommerce.order.adapter.out.web.request.converter.PromotionRequestConverter;
import com.example.ecommerce.order.adapter.out.web.response.converter.ProductResponseConverter;
import com.example.ecommerce.order.adapter.out.web.response.converter.PromotionResponseConverter;
import com.example.ecommerce.order.domain.model.OrderItem;
import com.example.ecommerce.order.port.out.ProductDataProvider;
import com.example.ecommerce.order.port.out.PromotionDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;

@RequiredArgsConstructor
@Component
public class PromotionDataWebAdapter implements PromotionDataProvider {

    private final PromotionWebClient client;

    @Override
    public OrderItem apply(final OrderItem orderItem) {
        if( orderItem == null){
            return null;
        }

        PromotionRequest request = PromotionRequestConverter.from(orderItem);
        return PromotionResponseConverter.to(client.apply(request));
    }
}
