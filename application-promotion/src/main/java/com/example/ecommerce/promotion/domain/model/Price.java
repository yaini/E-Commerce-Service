package com.example.ecommerce.promotion.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder(toBuilder = true)
public class Price {
    BigDecimal unitPrice;
    BigDecimal totalPrice;
}
