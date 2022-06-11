package com.example.ecommerce.catalog.domain.service;

import com.example.ecommerce.catalog.domain.command.SaveCatalogCommand;
import com.example.ecommerce.catalog.domain.model.Catalog;
import com.example.ecommerce.catalog.port.in.SaveCatalogUseCase;
import com.example.ecommerce.catalog.port.out.CatalogDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
@Transactional
@RequiredArgsConstructor
@Service
public class SaveCatalogService implements SaveCatalogUseCase {

    private final CatalogDataProvider dataProvider;

    @Override
    public Catalog execute(final @Valid SaveCatalogCommand command) {
        return dataProvider.save(command.getUser());
    }
}
