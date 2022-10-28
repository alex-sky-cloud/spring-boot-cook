package com.cook.api.lib.client;

import com.cook.api.lib.model.RandomJokeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Здесь описываем маршрут веб-клиента, который прочитав свойства из *-application.yml,
 * сгенерирует шаблон запроса к удаленному серверу
 * 'name' - можете указать любое имя создаваемого маршрута(должно быть уникальным по отношению
 * к другим маршрутам, если они будут создаваться
 * 'url' - здесь указываете адрес, по которому будет выполняться запрос
 */
@FeignClient(name = "random.joke.api", url = "${random.joke.api.url}")
public interface RandomJokeClient {
    @GetMapping
    RandomJokeResponse getRandomJoke();
}
