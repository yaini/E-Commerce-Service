package com.example.ecommerce.order.domain.command;

import com.example.ecommerce.order.domain.model.Order;
import com.example.ecommerce.order.domain.model.OrderItem;
import com.example.ecommerce.order.domain.model.Product;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.stream.Collectors;

@Builder
@Getter
public class SaveOrderCommand {
    @Min(1)
    @NotNull
    private Long userId;

    @NotBlank
    private String comment;

    @Size(min = 1)
    private Collection<SaveOrderItemCommand> items;

    public Order getOrder(){
        return Order.builder()
                .userId(this.userId)
                .comment(this.comment)
                .build();
    }

    public Collection<OrderItem> getItems(){
        return this.items.stream()
                .map(SaveOrderItemCommand::getOrderItem)
                .collect(Collectors.toUnmodifiableList());
    }

    public Collection<Long> getProductIds(){
        return this.items.stream()
                .map(SaveOrderItemCommand::getProductId)
                .collect(Collectors.toUnmodifiableList());
    }
}
