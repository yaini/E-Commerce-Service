package com.example.ecommerce.order.adapter.in.web.controller;

import com.example.ecommerce.order.adapter.in.web.OrderWebAdapter;
import com.example.ecommerce.order.adapter.in.web.request.BrowseOrderRequest;
import com.example.ecommerce.order.adapter.in.web.request.SaveOrderRequest;
import com.example.ecommerce.order.adapter.in.web.response.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
@RestController
public class OrderController {

    private final OrderWebAdapter adapter;

    @GetMapping
    public ResponseEntity<List<OrderResponse>> browse(final @RequestBody BrowseOrderRequest request){
        return ResponseEntity.ok(adapter.browse(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> read(final @PathVariable("id") Long id){
        return ResponseEntity.ok(adapter.read(id));
    }

    @PostMapping
    public ResponseEntity<OrderResponse> add(final SaveOrderRequest request){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(adapter.add(request).getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

}
