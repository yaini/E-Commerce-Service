package com.example.ecommerce.order.adapter.out.web.client;

import com.example.ecommerce.order.adapter.out.web.response.ProductResponse;
import com.example.ecommerce.order.adapter.out.web.response.converter.ProductResponseConverter;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.Reader;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Component
public class ProductWebClient {
    private final WebClient webClient;

    @Value("${application.catalog.url}")
    private String BASE_URL;

    @CircuitBreaker(name = "catalog", fallbackMethod = "catalogFallback")
    public Collection<ProductResponse> findBy(final Collection<Long> ids){

        // TODO error handler
        return webClient.get()
                .uri( v -> v.path(BASE_URL).queryParam("ids", ids).build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<ProductResponse>>() {})
                .block();
    }

    private Collection<ProductResponse> catalogFallback(final Collection<Long> ids, final Throwable e){
        return Collections.emptyList();
    }

}
