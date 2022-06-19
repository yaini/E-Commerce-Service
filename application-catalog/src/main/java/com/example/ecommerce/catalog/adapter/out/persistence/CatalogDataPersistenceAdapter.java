package com.example.ecommerce.catalog.adapter.out.persistence;

import com.example.ecommerce.catalog.adapter.out.persistence.converter.CatalogEntityConverter;
import com.example.ecommerce.catalog.adapter.out.persistence.entity.CatalogEntity;
import com.example.ecommerce.catalog.adapter.out.persistence.repository.CatalogRepository;
import com.example.ecommerce.catalog.domain.model.Catalog;
import com.example.ecommerce.catalog.domain.query.SearchCatalogQuery;
import com.example.ecommerce.catalog.port.out.CatalogDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class CatalogDataPersistenceAdapter implements CatalogDataProvider {

    private final CatalogRepository repository;

    @Override
    public Optional<Catalog> findOne(final Long id) {
        return repository.findById(id).map(CatalogEntityConverter::to);
    }

    @Override
    public Catalog save(final Catalog data) {
        if( data == null ){
            return null;
        }

        CatalogEntity entity = CatalogEntityConverter.from(data);
        return CatalogEntityConverter.to(repository.save(entity));
    }

    @Override
    public List<Catalog> findBy(final SearchCatalogQuery query) {
        if( query == null ){
            return null;
        }

        return repository.findAllById(query.getIds()).stream()
                .map(CatalogEntityConverter::to)
                .collect(Collectors.toUnmodifiableList());
    }
}
