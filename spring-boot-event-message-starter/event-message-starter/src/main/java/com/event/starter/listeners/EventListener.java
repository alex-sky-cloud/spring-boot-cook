package com.event.starter.listeners;

import com.event.starter.model.Event;
import com.event.starter.properties.EventListenerProperties;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * Интерфейс, который необходимо реализовать для всех типов events,
 * на которые должно реагировать приложение.
 * Реализации EventListeners будут автоматически включены,
 * когда они будут являться частью контекста приложения (application context).
 */
@RequiredArgsConstructor
public abstract class EventListener {

    private final EventListenerProperties properties;

    /**
     * Данный метод получает событие, проверяем подписан ли вызывающий сервис на данное
     * событие и проверяет, соответствует ли тип полученного сообщения,
     * реестру заявленных типов, в свойстве event.starter.listener.enabled-events.
     */
    public void receive(Event event) {

        if(isEnabled(event) && isSubscribed(event)){
            onEvent(event);
        }
    }

    /**
     * Проверяем, подписан ли вызывающий сервис на данное событие.
     * @param event событие, которое нужно обработать.
     */
    private boolean isSubscribed(Event event) {

        String type = event.type();
        return type.equals(getSubscribedEventType());
    }

    /**
     * Проверяем, определен ли вызывающим сервисом тип события,
     * которое нужно "прослушивать"
     * @param event - событие, которое нужно обработать
     */
    private boolean isEnabled(Event event) {
        List<String> enabledEvents = properties.getEnabledEvents();
        String type = event.type();

        return enabledEvents.contains(type);
    }

    /**
     * Данный метод позволяет получить тип события, которые нужно
     * "прослушивать". Этот метод должен реализовываться в приложении,
     * которое реализует данную библиотеку
     * @return возвращается тип события, на которое подписан вызывающий
     * сервис.
     */
    protected abstract String getSubscribedEventType();

    /**
     * Данный метод вызывается, при возникновении события. Этот метод
     * реализуется сервисом, который использует данную библиотеку.
     * Происходит обработка события сервисом, который был подписан
     * на данное событие.
     * @param event - событие, на которое нужно среагировать
     */
    protected abstract void onEvent(Event event);
}
