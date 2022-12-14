package com.event.app.generator;

import com.event.starter.listeners.EventListener;
import com.event.starter.model.Event;
import com.event.starter.properties.EventListenerProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ConditionalOnProperty(value = "event.starter.enabled", havingValue = "true")
public class KafkaStreamEventListener extends EventListener {

	public KafkaStreamEventListener(EventListenerProperties properties) {
		super(properties);
	}

	@Override
	public String getSubscribedEventType() {
		return "kafka";
	}

	@Override
	public void onEvent(Event event) {
		log.info("received event {}", event);
	}
}
