package com.cook.api.lib.client;

import com.cook.api.lib.model.RandomJokeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "random.joke.api", url = "${random.joke.api.url}")
public interface RandomJokeClient {
    @GetMapping
    RandomJokeResponse getRandomJoke();
}
