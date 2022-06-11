package com.example.ecommerce.order.domain.command;

import com.example.ecommerce.order.domain.model.OrderItem;
import com.example.ecommerce.order.domain.model.Product;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Builder
@Getter
public class SaveOrderItemCommand {
    @Min(1)
    @NotNull
    private Long productId;

    @Min(1)
    @NotNull
    private Integer quantity;

    public OrderItem getOrderItem(){
        return OrderItem.builder()
                .product(new Product(this.productId))
                .quantity(this.quantity)
                .build();
    }
}
