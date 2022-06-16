package com.example.ecommerce.order.adapter.in.web.request;

import lombok.Getter;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.Collection;

@Getter
public class SaveOrderRequest {
    private Long userId;
    private String comment;
    private Collection<SaveOrderItemRequest> items;
}
