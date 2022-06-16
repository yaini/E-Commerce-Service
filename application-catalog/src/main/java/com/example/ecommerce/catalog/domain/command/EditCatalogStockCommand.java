package com.example.ecommerce.catalog.domain.command;

import com.example.ecommerce.catalog.domain.model.Catalog;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
public class EditCatalogStockCommand {
    @Min(1)
    @NotNull
    private Long id;

    @Min(0)
    @NotNull
    private Integer consume;

    public Catalog getCatalog(final Catalog source){
        return Catalog.builder()
                .id(id)
                .name(source.getName())
                .price(source.getPrice())
                .stock(source.getStock() - consume)
                .build();
    }
}

