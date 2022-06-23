package com.example.ecommerce.promotion.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Collection;

@Getter
@Builder(toBuilder = true)
public class PromotionItem {
    private Long id;
    private BigDecimal price;
    private Integer quantity;
    private Collection<Promotion> promotions;

    public void apply(final Promotion promotion){
        this.price = promotion.getDiscountPrice(this.price);
        this.quantity = promotion.getPromotionQuantity(this.quantity);
        this.promotions.add(promotion);
    }
}
