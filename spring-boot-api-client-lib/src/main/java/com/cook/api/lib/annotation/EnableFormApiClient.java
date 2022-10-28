package com.cook.api.lib.annotation;

import com.cook.api.lib.model.configuration.FormApiClientConfiguration;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Эту аннотацию нужно будет указать над классом-точкой входа в приложение,
 * которое будет использовать данную библиотеку, в качестве зависимости
 * Данная аннотацию указывает на то, что API данной библиотеки,
 * будет использоваться в RUNTIME.
 * Применяется данная аннотация на уровне класса(TYPE).
 * {@link Import} - указываем компилятору, что как только данная аннотация обнаруживается,
 * идет обращение к {@link FormApiClientConfiguration}, который укажет, как нужно настроить
 * подключаемую (данную) библиотеку для использования
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(FormApiClientConfiguration.class)
public @interface EnableFormApiClient {}
