package com.example.demo.service;

import com.example.demo.dao.PlayersDao;
import com.example.demo.model.Players;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class PlayerService {

    private PlayersDao playersDao;
    @Autowired
    public PlayerService(PlayersDao playersDao) {
        this.playersDao = playersDao;
    }

    public List<Players> getAllPlayers() {
        return playersDao.getPlayers();
    }

    public List<Players> getAllPlayersBlocking() {

        return playersDao.getPlayersBlocking();
    }

    public Flux<Players> getAllPlayersFlux() {
        return playersDao.getPlayersFlux();
    }
}
