package com.example.ecommerce.promotion.domain.model;

import java.math.BigDecimal;

public class BonusPromotion extends Promotion {

    private Integer bonus;

    @Override
    public PromotionPrice apply(final Price target) {
        if( target == null ){
            return null;
        }

        BigDecimal discount = target.getUnitPrice().multiply(BigDecimal.valueOf(bonus));

        return PromotionPrice.builder()
                .promotion(this)
                .price(target.getTotalPrice().subtract(discount))
                .build();
    }
}
