package com.event.app;

import com.event.starter.publishers.EventPublisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MicroServiceApplicationTests {

    @Autowired(required = false)
    private EventPublisher eventPublisher;

    @Test
    void eventPublisherIsAvailable() {
        assertThat(eventPublisher).isNotNull();
    }

}
