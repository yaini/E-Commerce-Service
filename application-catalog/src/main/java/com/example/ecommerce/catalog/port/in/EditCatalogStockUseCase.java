package com.example.ecommerce.catalog.port.in;

import com.example.ecommerce.catalog.domain.command.EditCatalogStockCommand;
import com.example.ecommerce.catalog.domain.model.Catalog;

import javax.validation.Valid;
import javax.validation.constraints.Min;

public interface EditCatalogStockUseCase {
    Catalog execute(final @Valid EditCatalogStockCommand command);
}
