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
                new Players(1, "Virat Kohli", "King Kohli"),
                new Players(2, "MS Dhoni", "Captain Cool"),
                new Players(2, "Sachin Tendulkar", "Master Blaster"),
                new Players(4, "Rohit Sharma", "Hitman"),
                new Players(5, "Ravindra Jadeja", "Sir Jadeja"),
                new Players(6, "Jasprit Bumrah", "Boom Boom")
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
                .peek(players -> System.out.println(players.getId() + "-" + players.getName()))
                .collect(Collectors.toList());
    }

    public Flux<Players> getPlayersFlux() {
        return playerFlux()
                .delayElements(Duration.ofSeconds(2))
                .doOnNext(players -> System.out.println(players.getId() + " -Stream- " + players.getName()));
    }

    public static Flux<Players> playerFlux() {
        return Flux.just(
                new Players(1, "Virat Kohli", "King Kohli"),
                new Players(2, "MS Dhoni", "Captain Cool"),
                new Players(2, "Sachin Tendulkar", "Master Blaster"),
                new Players(4, "Rohit Sharma", "Hitman"),
                new Players(5, "Ravindra Jadeja", "Sir Jadeja"),
                new Players(6, "Jasprit Bumrah", "Boom Boom")
        ).delayElements(Duration.ofSeconds(1));
    }
}
