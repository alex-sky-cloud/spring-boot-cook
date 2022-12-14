package com.event.app.generator;

import com.event.starter.model.Event;
import com.event.starter.publishers.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(value = "event.starter.enabled", havingValue = "true")
@RequiredArgsConstructor
public class EventGenerator {

	private final EventPublisher eventPublisher;

	@Scheduled(fixedRate = 2000)
	public void generateEvent() {
		Event event = new Event("kafka-stream", "This is a kafka-stream event");
		eventPublisher.publishEvent(event);
	}

}
