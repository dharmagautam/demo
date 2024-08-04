package com.example.demo.handler;

import com.example.demo.dao.PlayersDao;
import com.example.demo.model.Players;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlayerStreamHandler {
    @Autowired
    private PlayersDao playersDao;
    public Mono<ServerResponse> getPlayersStreamReactive(ServerRequest serverRequest) {
        Flux<Players> playersFlux = playersDao.getPlayersFlux();
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(playersFlux, Players.class);
    }

    public Mono<ServerResponse> getPlayersStream(ServerRequest serverRequest) {
        Flux<Players> playersFlux = playersDao.getPlayersFlux();
        return ServerResponse.ok().body(playersFlux, Players.class);
    }
}
