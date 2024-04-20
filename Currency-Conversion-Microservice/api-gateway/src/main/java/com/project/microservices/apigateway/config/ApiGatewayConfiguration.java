package com.project.microservices.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gateWayRouter(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p-> p.path("/get")
                        .filters(gatewayFilterSpec-> gatewayFilterSpec
                                .addRequestHeader("MyHeader","Added Header My URI")
                                .addRequestParameter("param","myParamValue")
                        )
                        .uri("http://httpbin.org:80"))
                .route(p->p.path("/currency-exchange/**")
                        .uri("lb://currency-exchange"))
                .route(p->p.path("/currency-conversion/**")
                        .uri("lb://currency-conversion")) // here lb is for load balancing
                .route(p->p.path("/currency-conversion-new/**")
                        .filters(gatewayFilterSpec ->gatewayFilterSpec.rewritePath("/currency-conversion-new/(?<segment>.*)",
                                "/currency-conversion/${segment}"))
                        .uri("lb://currency-conversion"))
                .build();
    }
}
