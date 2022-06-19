package com.example.ecommerce.catalog.adapter.in.queue.listener;

import com.example.ecommerce.catalog.adapter.in.queue.CatalogMessageQueueAdapter;
import com.example.ecommerce.catalog.adapter.in.queue.message.OrderMessage;
import com.example.ecommerce.catalog.domain.command.EditCatalogStockCommand;
import com.example.ecommerce.catalog.port.in.EditCatalogStockUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OrderListener {

    private final CatalogMessageQueueAdapter adapter;

    @KafkaListener(topics="${spring.kafka.template.default-topic}")
    public void process(final @Payload OrderMessage message){
        adapter.edit(message);
    }
}
