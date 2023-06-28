package io.github.simplydemo.config;

import io.github.simplydemo.routes.HelloRouter;
import io.github.simplydemo.routes.HealthRouter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.ViewResolverRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
@EnableWebFlux
public class WebConfig implements WebFluxConfigurer {
    // private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    @Bean
    public RouterFunction<ServerResponse> healthRoute(HealthRouter router) {
        return RouterFunctions.route(GET("/health"), router::health);
    }

    @Bean
    public RouterFunction<ServerResponse> helloRoute(HelloRouter router) {
        return RouterFunctions.route(GET("/hello").and(accept(MediaType.APPLICATION_JSON)), router::helloHandler);
    }

    public void configureHttpMessageCodecs(ServerCodecConfigurer configurer) {
        // configure message conversion...
    }

    public void addCorsMappings(CorsRegistry registry) {
        // configure CORS...
    }

    public void configureViewResolvers(ViewResolverRegistry registry) {
        // configure view resolution for HTML rendering...
    }
}
