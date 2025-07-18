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
public class OrderRoutes {

    // create
    @Bean
    public RouterFunction<ServerResponse> createOrderServiceRoute() {
        return GatewayRouterFunctions.route("order_service")
                .route(RequestPredicates.path("/api/order/create"),
                        HandlerFunctions.http())
                .before(BeforeFilterFunctions.uri(URI.create("http://localhost:8082")))
                .build();
    }

    // all
    @Bean
    public RouterFunction<ServerResponse> allOrdersServiceRoute() {
        return GatewayRouterFunctions.route("order_service")
                .route(RequestPredicates.path("/api/order/all"),
                        HandlerFunctions.http())
                .before(BeforeFilterFunctions.uri(URI.create("http://localhost:8082")))
                .build();
    }
}
