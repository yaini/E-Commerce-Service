package com.example.ecommerce.catalog.adapter.in.web.request.converter;

import com.example.ecommerce.catalog.adapter.in.web.request.SaveCatalogRequest;
import com.example.ecommerce.catalog.domain.command.SaveCatalogCommand;

public class CatalogRequestConverter {

    public static SaveCatalogCommand to(final SaveCatalogRequest request){
        if( request == null ){
            return null;
        }

        return SaveCatalogCommand.builder()
                .name(request.getName())
                .price(request.getPrice())
                .stock(request.getStock())
                .build();
    }
}
