package com.example.ecommerce.promotion.domain.model;

import java.math.BigDecimal;

public class DiscountPromotion extends Promotion {

    private BigDecimal discount;

    @Override
    public BigDecimal getDiscountPrice(final BigDecimal price) {
        return price.multiply(this.discount);
    }

    @Override
    public Integer getPromotionQuantity(final Integer quantity) {
        return quantity;
    }

}
