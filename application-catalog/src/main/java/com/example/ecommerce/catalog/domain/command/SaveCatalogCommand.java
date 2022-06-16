package com.example.ecommerce.catalog.domain.command;

import com.example.ecommerce.catalog.domain.model.Catalog;
import lombok.Builder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Builder
public class SaveCatalogCommand {
    @NotBlank
    private String name;
    @Min(0)
    private BigDecimal price;
    @Min(0)
    private Integer stock;

    public Catalog getUser(){
        return Catalog.builder()
                .name(this.name)
                .price(this.price)
                .stock(this.stock)
                .build();
    }
}
