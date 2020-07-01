package com.rapidkart.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalHostRouteConfig {

    @Bean
    public RouteLocator localHostRoutes(RouteLocatorBuilder builder) {

        return builder.routes()
                .route(r -> r.path("/customer/api/v1/*")
                .uri("http://localhost:8070")
                .id("rapidkart-customer-service"))
                .build();
    }
}
