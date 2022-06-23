package com.example.ecommerce.promotion.domain.service;

import com.example.ecommerce.promotion.domain.model.Promotion;
import com.example.ecommerce.promotion.domain.command.GetProductPromotionPriceCommand;
import com.example.ecommerce.promotion.domain.model.PromotionItem;
import com.example.ecommerce.promotion.port.in.ItemPromotionUseCase;
import com.example.ecommerce.promotion.port.out.PromotionDataProvider;
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
public class ItemPromotionService implements ItemPromotionUseCase {

    private final PromotionDataProvider dataProvider;

    public PromotionItem execute(final @Valid GetProductPromotionPriceCommand command){
        Map<Long, Promotion> promotions = dataProvider.findAllBy(command.getUserId()).stream()
                .collect(HashMap::new, (m, v) -> m.put(v.getId(), v), HashMap::putAll);

        PromotionItem item = command.getItem();

        command.getIds().stream()
                .filter(promotions::containsKey)
                .map(promotions::get)
                .filter(Promotion::validate)
                .forEach(item::apply);

        return item;
    }
}
