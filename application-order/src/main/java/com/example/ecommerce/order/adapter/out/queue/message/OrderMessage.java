package com.example.ecommerce.order.adapter.out.queue.message;

import com.example.ecommerce.order.domain.model.OrderItem;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;

@Builder
@Getter
@Setter
public class OrderMessage implements Serializable {
    private Long id;
    private Long userId;
    private Collection<OrderItemMessage> items;
}
