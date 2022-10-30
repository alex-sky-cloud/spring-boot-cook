package com.event.starter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@ConfigurationProperties(prefix = "event.starter.listener")
@Component
@Data
public class EventListenerProperties {

	/**Здесь определяем список свойств. Каждое свойство - это
	 * некий тип события (event). Значения этих свойств,
	 * то есть те события которые определены, что за ними нужно наблюдать,
	 * будут переданы в реализации абстрактного класса
	 * {@link com.event.starter.listeners.EventListener}.
	 * Все остальные события не определенные в этом списке, будут проигнорированы
	 */
	private List<String> enabledEvents = Collections.emptyList();
}