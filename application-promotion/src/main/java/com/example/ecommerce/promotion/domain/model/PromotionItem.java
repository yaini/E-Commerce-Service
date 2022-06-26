package com.example.ecommerce.promotion.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Collection;

@Getter
@Builder(toBuilder = true)
public class PromotionItem {
    private Long id;
    private Price price;
    private Integer quantity;
    private Collection<PromotionPrice> promotions;

    public void apply(final Promotion target){
        PromotionPrice applied = target.apply(this.price);

        this.promotions.add(applied);
        this.price = new Price(this.price.getUnitPrice(), applied.getPrice());
    }
}
