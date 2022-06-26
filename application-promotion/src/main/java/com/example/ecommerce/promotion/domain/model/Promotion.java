package com.example.ecommerce.promotion.domain.model;

import com.example.ecommerce.promotion.domain.model.enumurated.PromotionType;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public abstract class Promotion {

    private Long id;
    private Long campaignId;
    private PromotionType type;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public boolean validation(){
        LocalDateTime now = LocalDateTime.now();

        if( startTime.isAfter(now) || endTime.isBefore(now) ){
            return false;
        }

        return true;
    }

    public abstract PromotionPrice apply(final Price target);

}
