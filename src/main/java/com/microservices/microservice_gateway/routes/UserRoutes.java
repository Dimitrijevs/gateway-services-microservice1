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
public class UserRoutes {

    // register
    @Bean
    public RouterFunction<ServerResponse> registerUserServiceRoute() {
        return GatewayRouterFunctions.route("user_service")
            .route(RequestPredicates.path("/api/auth/register"), HandlerFunctions.http())
            .before(BeforeFilterFunctions.uri(URI.create("http://localhost:8086")))
            .build();
    }

    // login
    @Bean
    public RouterFunction<ServerResponse> loginUserServiceRoute() {
        return GatewayRouterFunctions.route("user_service")
            .route(RequestPredicates.path("/api/auth/login"), HandlerFunctions.http())
            .before(BeforeFilterFunctions.uri(URI.create("http://localhost:8086")))
            .build();
    }

    // hello
    @Bean
    public RouterFunction<ServerResponse> greetingUserServiceRoute() {
        return GatewayRouterFunctions.route("user_service")
            .route(RequestPredicates.path("/api/auth/hello"), HandlerFunctions.http())
            .before(BeforeFilterFunctions.uri(URI.create("http://localhost:8086")))
            .build();
    }
}
