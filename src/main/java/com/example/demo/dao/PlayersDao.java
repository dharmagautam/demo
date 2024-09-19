package com.example.demo.dao;

import com.example.demo.model.Players;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayersDao {
    public List<Players> getPlayers() {
        return playersList();
    }
    private List<Players> playersList() {
        return List.of(
                new Players(1, "Sachin", "Tendulkar", "MI"),
                new Players(2, "Jasprit", "Bumrah", "MI"),
                new Players(3, "Rohit", "Sharma", "MI"),
                new Players(4, "MS", "Dhoni", "CSK"),
                new Players(5, "Ravindra", "Jadeja", "CSK"),
                new Players(6, "Dinesh", "Karthik", "RCB"),
                new Players(7, "Virat", "Kohli", "RCB")
        );
    }

    private static void sleepExecution(Players players) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Players> getPlayersBlocking() {
        return getPlayers().stream().peek(PlayersDao::sleepExecution)
                .peek(players -> System.out.println(players.getId() + "-" + players.getFirstName()))
                .collect(Collectors.toList());
    }

    public Flux<Players> getPlayersFlux() {
        return playerFlux()
                .delayElements(Duration.ofSeconds(2))
                .doOnNext(players -> System.out.println(players.getId() + " -Stream- " + players.getFirstName()));
    }

    public static Flux<Players> playerFlux() {
        return Flux.just(
                new Players(1, "Sachin", "Tendulkar", "MI"),
                new Players(2, "Jasprit", "Bumrah", "MI"),
                new Players(3, "Rohit", "Sharma", "MI"),
                new Players(4, "MS", "Dhoni", "CSK"),
                new Players(5, "Ravindra", "Jadeja", "CSK"),
                new Players(6, "Dinesh", "Karthik", "RCB"),
                new Players(7, "Virat", "Kohli", "RCB")
        ).delayElements(Duration.ofSeconds(1));
    }
}
