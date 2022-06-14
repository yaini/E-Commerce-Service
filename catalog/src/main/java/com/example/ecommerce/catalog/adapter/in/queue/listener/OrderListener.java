package com.example.ecommerce.catalog.adapter.in.queue.listener;

import com.example.ecommerce.catalog.adapter.in.queue.message.OrderMessage;
import com.example.ecommerce.catalog.domain.command.EditCatalogStockCommand;
import com.example.ecommerce.catalog.port.in.EditCatalogStockUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OrderListener {

    private final EditCatalogStockUseCase editUseCase;

    @KafkaListener(topics="${kafka.template.default-topic}")
    public void process(final OrderMessage message){

        message.getItems().forEach( v ->
                editUseCase.execute(new EditCatalogStockCommand(v.getProductId(), v.getQuantity())));
    }
}
