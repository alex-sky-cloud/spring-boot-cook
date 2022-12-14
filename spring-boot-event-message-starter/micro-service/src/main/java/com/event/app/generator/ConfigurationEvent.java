package com.event.app.generator;

import com.event.starter.properties.EventListenerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationEvent {

    @Bean
    public EventListenerProperties properties() {
        return new EventListenerProperties();
    }
}
