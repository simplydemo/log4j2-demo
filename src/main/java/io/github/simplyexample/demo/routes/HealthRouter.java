package io.github.simplyexample.demo.routes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class HealthRouter {

    public Mono<ServerResponse> health(ServerRequest request) {
        return ServerResponse.ok().body(Mono.just("OK"), String.class);
    }

}
