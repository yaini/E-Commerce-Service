package com.example.ecommerce.catalog.port.in;

import com.example.ecommerce.catalog.domain.command.SaveCatalogCommand;
import com.example.ecommerce.catalog.domain.model.Catalog;

import javax.validation.Valid;

public interface SaveCatalogUseCase {

    Catalog execute(final @Valid SaveCatalogCommand command);
}
