package com.example.ecommerce.promotion.domain.model;

import java.math.BigDecimal;

public class FreePromotion extends Promotion {

    @Override
    public PromotionPrice apply(final Price target) {
        if( target == null ){
            return null;
        }

        return PromotionPrice.builder()
                .promotion(this)
                .price(BigDecimal.ZERO)
                .build();
    }
}
