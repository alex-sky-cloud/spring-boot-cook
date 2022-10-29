package com.event.starter.publishers;


import com.event.starter.listeners.EventListener;
import com.event.starter.model.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Фиктивная реализация EventPublisher (издателя событий).
 * Просто публикует событие для всех Listeners,
 * которые подписаны(subscribed) на это событие(event). Очевидно,
 * что это решение не работает за пределами одного контекста приложения
 * (single application context)(хотя можно создать несколько application context,
 * но это плохая идея)
 */
@Slf4j
@RequiredArgsConstructor
public class EventPublisher {

    /** Список Listeners, которые должны быть уведомлены,
     * о публикуемых событиях.*/
    private final List<EventListener> listeners;

    /**
     * Данный метод регистрирует события, которые публикуются.
     * Этот метод используется сервисом, который использует данную библиотеку.
     * Этот вызывающий сервис и будет публиковать список событий,
     * которые нужно "прослушивать", для него.
     * @param event публикуемое событие
     */
    public void publishEvent(Event event) {

        log.info("publishing event: {}", event);

        for (EventListener listener : listeners) {
            listener.receive(event);
        }
    }
}
