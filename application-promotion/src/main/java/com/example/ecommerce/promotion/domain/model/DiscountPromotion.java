package com.example.ecommerce.promotion.domain.model;

import java.math.BigDecimal;

public class DiscountPromotion extends Promotion {

    private BigDecimal discount;

    @Override
    public PromotionPrice apply(final Price target) {
        if( target == null ){
            return null;
        }

        BigDecimal price = target.getTotalPrice();

        return PromotionPrice.builder()
                .promotion(this)
                .price(price.multiply(discount))
                .build();
    }
}
