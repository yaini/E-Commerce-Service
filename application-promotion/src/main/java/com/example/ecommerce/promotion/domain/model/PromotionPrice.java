package com.example.ecommerce.promotion.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class PromotionPrice {
    private Promotion promotion;
    private BigDecimal price;
}
