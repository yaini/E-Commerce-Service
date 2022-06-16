package com.example.ecommerce.catalog.adapter.out.persistence.repository;

import com.example.ecommerce.catalog.adapter.out.persistence.entity.CatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends JpaRepository<CatalogEntity, Long> {
}
