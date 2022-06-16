package com.example.ecommerce.catalog.domain.service;

import com.example.ecommerce.catalog.domain.command.EditCatalogStockCommand;
import com.example.ecommerce.catalog.domain.model.Catalog;
import com.example.ecommerce.catalog.port.in.EditCatalogStockUseCase;
import com.example.ecommerce.catalog.port.out.CatalogDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Min;

@Validated
@RequiredArgsConstructor
@Service
public class EditCatalogStockService implements EditCatalogStockUseCase {

    private final CatalogDataProvider dataProvider;

    @Override
    public Catalog execute(final @Valid EditCatalogStockCommand command){
        Catalog source = dataProvider.findOne(command.getId()).orElseThrow();

        if( command.getConsume() > source.getStock() ){
            throw new IllegalArgumentException();
        }

        return dataProvider.save(command.getCatalog(source));
    }
}
