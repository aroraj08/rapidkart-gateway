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
                 .route(r -> r.path("/customer/api/v1/*")
                 .uri("lb://rapidkart-customer-service")
                 .id("customer-service"))
                 .route(r -> r.path("/order/api/v1/*")
                 .uri("lb://rapidkart-order-service")
                 .id("order-service"))
                .build();
    }
}
