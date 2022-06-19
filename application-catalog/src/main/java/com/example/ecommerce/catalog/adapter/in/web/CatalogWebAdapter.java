package com.example.ecommerce.catalog.adapter.in.web;

import com.example.ecommerce.catalog.adapter.in.web.request.BrowseCatalogRequest;
import com.example.ecommerce.catalog.adapter.in.web.request.SaveCatalogRequest;
import com.example.ecommerce.catalog.adapter.in.web.request.converter.CatalogRequestConverter;
import com.example.ecommerce.catalog.adapter.in.web.response.CatalogResponse;
import com.example.ecommerce.catalog.adapter.in.web.response.converter.CatalogResponseConverter;
import com.example.ecommerce.catalog.domain.model.Catalog;
import com.example.ecommerce.catalog.domain.query.GetCatalogQuery;
import com.example.ecommerce.catalog.domain.query.SearchCatalogQuery;
import com.example.ecommerce.catalog.port.in.GetCatalogUseCase;
import com.example.ecommerce.catalog.port.in.SaveCatalogUseCase;
import com.example.ecommerce.catalog.port.in.SearchCatalogUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CatalogWebAdapter {

    private final SearchCatalogUseCase searchUseCase;
    private final GetCatalogUseCase getUseCase;
    private final SaveCatalogUseCase saveUseCase;

    public CatalogResponse add(final SaveCatalogRequest request){
        Catalog user = saveUseCase.execute(CatalogRequestConverter.to(request));
        return CatalogResponseConverter.from(user);
    }

    public CatalogResponse read(final Long id) {
        return CatalogResponseConverter.from(getUseCase.execute(new GetCatalogQuery(id)));
    }

    public List<CatalogResponse> browse(final BrowseCatalogRequest request) {
        return CatalogResponseConverter.from(searchUseCase.execute(new SearchCatalogQuery(request.getIds())));
    }
}
