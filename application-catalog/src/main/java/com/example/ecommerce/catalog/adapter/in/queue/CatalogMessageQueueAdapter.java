package com.example.ecommerce.catalog.adapter.in.queue;

import com.example.ecommerce.catalog.adapter.in.queue.message.OrderMessage;
import com.example.ecommerce.catalog.domain.command.EditCatalogStockCommand;
import com.example.ecommerce.catalog.port.in.EditCatalogStockUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CatalogMessageQueueAdapter {

    private final EditCatalogStockUseCase editUseCase;

    public void edit(final OrderMessage message){
        if( message == null ){
            return;
        }

        message.getItems().forEach( v ->
                editUseCase.execute(new EditCatalogStockCommand(v.getProductId(), v.getQuantity())));
    }

}
