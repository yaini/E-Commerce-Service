package com.example.ecommerce.promotion.port.out;

import com.example.ecommerce.promotion.domain.model.Promotion;

import java.util.Collection;

public interface PromotionDataProvider {
    Collection<Promotion> findAllBy(final Long userId);
}
