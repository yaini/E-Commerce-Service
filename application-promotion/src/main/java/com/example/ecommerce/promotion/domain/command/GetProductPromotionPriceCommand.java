package com.example.ecommerce.promotion.domain.command;

import com.example.ecommerce.promotion.domain.model.PromotionItem;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

@Getter
public class GetProductPromotionPriceCommand {
    private Collection<Long> ids;
    private Long userId;
    private Long productId;
    private Integer quantity;
    private BigDecimal price;

    public PromotionItem getItem(){
        return PromotionItem.builder()
                .id(this.productId)
                .quantity(this.quantity)
                .price(this.price)
                .promotions(new ArrayList<>())
                .build();
    }
}
