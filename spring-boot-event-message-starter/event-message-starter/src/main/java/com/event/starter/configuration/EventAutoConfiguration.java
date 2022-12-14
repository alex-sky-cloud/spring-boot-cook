package com.event.starter.configuration;


import com.event.starter.listeners.EventListener;
import com.event.starter.properties.EventListenerProperties;
import com.event.starter.properties.EventStarterProperties;
import com.event.starter.publishers.EventPublisher;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * "Точка входа" в данную библиотеку.(Здесь нет класса, помеченного
 * аннотацией @SpringBootApplication). Данный класс будет регистрировать
 * и настраивать компоненты данной библиотеки.
 */
@Configuration
@ConditionalOnClass(name = {
        "com.event.starter.mocks.KafkaConnect",
        "com.event.starter.mocks.KafkaStream"
})
@ConditionalOnProperty(value = "event.starter.enabled", havingValue = "true")
@EnableConfigurationProperties(value = {
        EventListenerProperties.class,
        EventStarterProperties.class
})
public class EventAutoConfiguration {

    /**
     * EventPublisher должен "знать" о всех Listeners,
     * которые будут "слушать" зарегистрированные events
     * Таким образом, вызывающий сервис, должен будет только
     * "внедрить" (через конструктор) в своем компоненте, данный
     * компонент, чтобы использовать
     * метод {@link com.event.starter.publishers.EventPublisher#publishEvent}
     *
     * @param listeners список Listeners, который предоставит (реализует) вызывающий сервис,
     *                  использующий данную библиотеку
     * @return настроенный компонент EventPublisher
     */
    @Bean
    EventPublisher eventPublisher(List<EventListener> listeners) {
        return new EventPublisher(listeners);
    }
}