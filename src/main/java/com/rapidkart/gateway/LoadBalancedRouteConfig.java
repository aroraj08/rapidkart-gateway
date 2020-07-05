package com.rapidkart.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local-discovery")
public class LoadBalancedRouteConfig {

    @Bean
    public RouteLocator loadBalancedRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                 .route(r -> r.path("/api/v1/customers/*", "/api/v1/customers*")
                 //.uri("lb://rapidkart-customer-service")
                   .uri("http://localhost:8070")
                 .id("customer-service"))
                 .route(r -> r.path("/api/v1/orders/*", "/api/v1/orders*")
                 //.uri("lb://rapidkart-order-service")
                   .uri("http://localhost:8071")
                 .id("order-service"))
                .build();
    }
}
