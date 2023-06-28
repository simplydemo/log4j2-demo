package io.github.simplyexample.demo.routes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class HelloRouter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Mono<ServerResponse> helloHandler(ServerRequest request) {
        logger.info("Hello, WebFlux!");
        return ServerResponse.ok().body(Mono.just("Hello, WebFlux!"), String.class);
    }

}
