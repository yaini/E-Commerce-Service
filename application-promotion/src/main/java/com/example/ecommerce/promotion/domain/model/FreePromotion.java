package com.example.ecommerce.promotion.domain.model;

import java.math.BigDecimal;

public class FreePromotion extends Promotion{

    @Override
    public BigDecimal getDiscountPrice(final BigDecimal price) {
        return BigDecimal.ZERO;
    }

    @Override
    public Integer getPromotionQuantity(final Integer quantity) {
        return quantity;
    }

}
