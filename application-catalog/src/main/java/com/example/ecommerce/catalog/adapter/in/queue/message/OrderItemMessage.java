package com.example.ecommerce.catalog.adapter.in.queue.message;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemMessage implements Serializable {
    private Long productId;
    private Integer quantity;
}
