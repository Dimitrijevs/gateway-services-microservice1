package com.microservices.microservice_gateway.routes;

import java.net.URI;

import org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class ProductRoutes {

    // create
    @Bean
    public RouterFunction<ServerResponse> createProductServiceRoute() {
        return GatewayRouterFunctions.route("product_service")
                .route(RequestPredicates.path("/api/product/create"),
                        HandlerFunctions.http())
                .before(BeforeFilterFunctions.uri(URI.create("http://localhost:8081")))
                .build();
    }

    // all
    @Bean
    public RouterFunction<ServerResponse> allProductsServiceRoute() {
        return GatewayRouterFunctions.route("product_service")
                .route(RequestPredicates.path("/api/product/all"),
                        HandlerFunctions.http())
                .before(BeforeFilterFunctions.uri(URI.create("http://localhost:8081")))
                .build();
    }
}
