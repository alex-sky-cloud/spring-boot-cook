package com.cook.api.lib.configuration;


import com.cook.api.lib.client.RandomJokeClient;
import com.cook.api.lib.proxy.FormApiClientProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@EnableFeignClients(clients = RandomJokeClient.class)
@ComponentScan(basePackageClasses = FormApiClientProxy.class)
@Configuration
@PropertySource(
        value = "classpath:form-api-application.yml",
        factory = YamlPropertySourceFactory.class)
public class FormApiClientConfiguration {
}
