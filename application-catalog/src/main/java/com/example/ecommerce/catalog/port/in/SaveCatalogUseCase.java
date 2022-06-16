package com.example.ecommerce.catalog.port.in;

import com.example.ecommerce.catalog.domain.command.SaveCatalogCommand;
import com.example.ecommerce.catalog.domain.model.Catalog;

public interface SaveCatalogUseCase {

    Catalog execute(final SaveCatalogCommand command);
}
