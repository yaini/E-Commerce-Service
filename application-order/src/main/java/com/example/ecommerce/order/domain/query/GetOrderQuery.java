package com.example.ecommerce.order.domain.query;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class GetOrderQuery {
    @Min(1)
    @NotNull
    private Long id;
}
