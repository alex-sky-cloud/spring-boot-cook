package com.event.starter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "event.starter")
@Data
public class EventStarterProperties {

    /**
     * Установка данного свойства в true, указывает на то, что стартер, настроит
     * свою конфигурацию только в этом случае.
     * По умолчанию, значение данного свойства - false.
     */
    public Boolean enabled;
}
