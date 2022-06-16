package com.example.ecommerce.support.security.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.yml")
public class JwtConfig {

    @Value("${jwt.secret}")
    private String secret;

    @Bean
    public JwtParser parser() {
        return new JwtParser(secret);
    }
}
