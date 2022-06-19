package com.example.ecommerce.catalog.adapter.in.queue.message;

import lombok.*;

import java.io.Serializable;
import java.util.Collection;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderMessage implements Serializable {
    private Long id;
    private Long userId;
    private Collection<OrderItemMessage> items;
}
