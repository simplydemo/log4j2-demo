package io.github.simplyexample.demo;

import io.github.simplyexample.demo.routes.HealthRouter;
import io.github.simplyexample.demo.routes.HelloRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@SpringBootApplication
public class DemoApplication {

    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    @Bean
    public RouterFunction<ServerResponse> healthRoute(HealthRouter router) {
        return RouterFunctions.route(GET("/health"), router::health);
    }

    @Bean
    public RouterFunction<ServerResponse> helloRoute(HelloRouter router) {
        return RouterFunctions.route(GET("/hello").and(accept(MediaType.APPLICATION_JSON)), router::helloHandler);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
