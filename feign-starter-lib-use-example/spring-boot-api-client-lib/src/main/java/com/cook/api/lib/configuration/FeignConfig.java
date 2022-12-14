package com.cook.api.lib.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;


/**
 * логгирование клиента Feign. Аналогом может служить свойство
 * feign.client.config.random-api.loggerLevel = full
 * random-api - имя данное клиенту feign (см. атрибут name
 * в классе {@link com.cook.api.lib.client.RandomJokeClient}
 *
 * Или мы можем переопределить уровень конфигурации по умолчанию для всех клиентов feign:
 *
 * feign.client.config.default.loggerLevel = full
 */
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
