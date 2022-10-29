package com.event.starter.model;

import lombok.ToString;
import lombok.Value;

/**
 * Это контейнер, который будет аккумулировать данные,
 * полученные во время обработки событий.
 * @param type тип события
 * @param payload полезные данные(некоторая дополнительная информация)
 */
public record Event(String type, String payload) {
}