package com.example.ecommerce.promotion.domain.model;

import java.math.BigDecimal;

public class BonusPromotion extends Promotion {

    private Integer bonus;

    @Override
    public BigDecimal getDiscountPrice(final BigDecimal price) {
        return price;
    }

    @Override
    public Integer getPromotionQuantity(final Integer quantity) {
        return quantity + bonus;
    }

}
