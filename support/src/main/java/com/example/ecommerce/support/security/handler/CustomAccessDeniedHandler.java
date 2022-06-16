package com.example.ecommerce.support.security.handler;

import com.example.ecommerce.support.api.ApiResponseGenerator;
import com.example.ecommerce.support.security.servlet.ServletResponseWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private final ServletResponseWriter writer;

    @Override
    public void handle(
            final @NonNull HttpServletRequest request,
            final @NonNull HttpServletResponse response,
            final AccessDeniedException e) throws IOException {

        log.error("url : {} / error : {}", request.getRequestURI(), e.getMessage(), e);

        HttpStatus httpStatus = HttpStatus.FORBIDDEN;
        writer.execute(response, httpStatus.value(), ApiResponseGenerator.fail(httpStatus));
    }
}
