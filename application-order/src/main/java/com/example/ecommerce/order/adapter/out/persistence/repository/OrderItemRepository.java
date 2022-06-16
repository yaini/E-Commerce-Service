package com.example.ecommerce.order.adapter.out.persistence.repository;

import com.example.ecommerce.order.adapter.out.persistence.entity.OrderEntity;
import com.example.ecommerce.order.adapter.out.persistence.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {

    Collection<OrderItemEntity> findByOrderId(final Long orderId);
}
