package com.example.ecommerce.promotion.domain.model;

import com.example.ecommerce.promotion.domain.model.enumurated.PromotionType;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public abstract class Promotion {

    private Long id;
    private PromotionType type;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public boolean validate() {
        LocalDateTime now = LocalDateTime.now();

        if( startTime.isAfter(now) || endTime.isBefore(now) ){
            return false;
        }

        return true;
    }

    BigDecimal getDiscountPrice(final BigDecimal price){
        return price;
    }

    Integer getPromotionQuantity(final Integer quantity){
        return quantity;
    }

}
