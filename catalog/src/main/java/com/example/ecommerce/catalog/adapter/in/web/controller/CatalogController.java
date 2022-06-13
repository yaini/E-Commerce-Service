package com.example.ecommerce.catalog.adapter.in.web.controller;

import com.example.ecommerce.catalog.adapter.in.web.CatalogWebAdapter;
import com.example.ecommerce.catalog.adapter.in.web.request.BrowseCatalogRequest;
import com.example.ecommerce.catalog.adapter.in.web.request.SaveCatalogRequest;
import com.example.ecommerce.catalog.adapter.in.web.response.CatalogResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/catalogs")
@RestController
public class CatalogController {

    private final CatalogWebAdapter adapter;

    @GetMapping
    public ResponseEntity<List<CatalogResponse>> browse(final @RequestParam BrowseCatalogRequest request){
        return ResponseEntity.ok(adapter.browse(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CatalogResponse> read(final @PathVariable("id") Long id){
        return ResponseEntity.ok(adapter.read(id));
    }

    @PostMapping
    public ResponseEntity<CatalogResponse> add(final SaveCatalogRequest request){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(adapter.add(request).getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

}
