package com.example.ecommerce.order.domain.model;

import com.example.ecommerce.order.domain.command.SaveOrderItemCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Order {
    private Long id;
    private Long userId;
    private String comment;
    private Collection<OrderItem> items;

    public void bind(final Collection<OrderItem> items){
        this.items = items;
    }

    public BigDecimal getTotalPrice(){
        if( CollectionUtils.isEmpty(this.items) ){
            return BigDecimal.ZERO;
        }

        return items.stream()
                .map( v -> v.getProduct().getPrice().multiply(BigDecimal.valueOf(v.getQuantity())) )
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Collection<Long> getProductIds(){
        if( CollectionUtils.isEmpty(this.items) ){
            return Collections.emptyList();
        }

        return this.items.stream()
                .map( v -> v.getProduct().getId())
                .collect(Collectors.toUnmodifiableList());
    }
}
