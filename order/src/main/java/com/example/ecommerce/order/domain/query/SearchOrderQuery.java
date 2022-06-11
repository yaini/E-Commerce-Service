package com.example.ecommerce.order.domain.query;

import javax.validation.constraints.Min;

public class SearchOrderQuery {
    @Min(1)
    private Long userId;
}
