package com.example.ecommerce.promotion.port.in;

import com.example.ecommerce.promotion.domain.command.GetProductPromotionPriceCommand;
import com.example.ecommerce.promotion.domain.model.PromotionItem;

import javax.validation.Valid;

public interface ItemPromotionUseCase {

    PromotionItem execute(final Long userId, final @Valid GetProductPromotionPriceCommand command);
}
