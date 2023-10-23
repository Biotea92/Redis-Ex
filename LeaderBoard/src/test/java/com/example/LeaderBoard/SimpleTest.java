package com.example.LeaderBoard;

import com.example.LeaderBoard.service.RankingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class SimpleTest {

    @Autowired
    private RankingService rankingService;

    @Test
    void getRanks() {
        rankingService.getTopRank(1);

        // 1)
        Instant start = Instant.now();
        Long userRank = rankingService.getUserRank("user100");
        Duration elapsed = Duration.between(start, Instant.now());

        System.out.println(String.format("Rank(%d) - Took %d ms", userRank, elapsed.getNano() / 1_000_000));

        // 2)
        start = Instant.now();
        List<String> topRank = rankingService.getTopRank(10);
        elapsed = Duration.between(start, Instant.now());

        System.out.println(String.format("Range - Took %d ms", elapsed.getNano() / 1_000_000));
    }

    @Test
    void insertScore() {
        for (int i = 0; i < 1_000_000; i++) {
            int score = (int) (Math.random() * 1_000_000);
            String userId = "user" + i;
            rankingService.setUserScore(userId, score);
        }
    }

    @Test
    void inMemorySortPerformance() {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 1_000_000; i++) {
            int score = (int) (Math.random() * 1_000_000);
            list.add(score);
        }

        Instant start = Instant.now();
        Collections.sort(list); // nlogn
        Duration elapsed = Duration.between(start, Instant.now());
        System.out.println(elapsed.getNano() / 1_000_000 + "ms");
    }

}
