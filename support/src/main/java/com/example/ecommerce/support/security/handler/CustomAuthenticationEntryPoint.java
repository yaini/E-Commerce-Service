package com.example.ecommerce.support.security.handler;

import com.example.ecommerce.support.api.ApiResponseGenerator;
import com.example.ecommerce.support.security.servlet.ServletResponseWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ServletResponseWriter writer;

    @Override
    public void commence(
            final @NonNull HttpServletRequest request,
            final @NonNull HttpServletResponse response,
            final @NonNull AuthenticationException e) throws IOException {

        log.error("url : {} / error : {}", request.getRequestURI(), e.getMessage(), e);

        HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;
        writer.execute(response, httpStatus.value(), ApiResponseGenerator.fail(httpStatus));
    }
}
