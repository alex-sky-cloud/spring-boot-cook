package com.cook.api.lib.configuration;


import com.cook.api.lib.client.RandomJokeClient;
import com.cook.api.lib.proxy.FormApiClientProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Это класс конфигурация для данной библиотеки:
 * {@link EnableFeignClients}- указываем клиента, который
 * будет генерировать шаблон запроса к удаленной системе (можно использовать basePackages())
 * {@link ComponentScan} - указываем класс, который будет обрабатывать ответы,
 * полученные от удаленной системы (можно использовать basePackages())
 * {@link PropertySource} - указали, что данная библиотека имеет свой собственный
 * *-application.yml, данные которого используем и указали класс {@link YamlPropertySourceFactory},
 * который будет производить "разбор" данных из указанного файла свойств
 */
@EnableFeignClients(basePackages = {"com.cook.api.lib"})
@ComponentScan(basePackages = {"com.cook.api.lib"})
@Configuration
@PropertySource(
        value = "classpath:form-api-application.yml",
        factory = YamlPropertySourceFactory.class)
public class FormApiClientConfiguration {

}