package com.example.demo.controller;

import com.example.demo.model.Players;
import com.example.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/players")
public class MyController {
    private PlayerService playerService;
    @Autowired
    public MyController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Players> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/blocking")
    public List<Players> getAllPlayersBlocking() {
        return playerService.getAllPlayersBlocking();
    }

    @GetMapping("/stream")
    public Flux<Players> getAllPlayersFlux() {
        return playerService.getAllPlayersFlux();
    }

    // back pressure enabled
    @GetMapping(value = "/reactive",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Players> getAllPlayersFluxReactive() {
        return playerService.getAllPlayersFlux();
    }
}
