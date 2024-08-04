package com.example.demo.router;

import com.example.demo.handler.PlayerStreamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Autowired
    private PlayerStreamHandler playerStreamHandler;
    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route()
                .GET("router/players", playerStreamHandler::getPlayersStream)
                .GET("router/stream", playerStreamHandler::getPlayersStreamReactive)
                .build();
    }
}
