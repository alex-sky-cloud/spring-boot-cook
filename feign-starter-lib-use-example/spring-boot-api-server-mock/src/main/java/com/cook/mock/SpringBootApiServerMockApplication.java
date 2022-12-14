package com.cook.mock;

import com.cook.api.lib.annotation.EnableFormApiClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFormApiClient
public class SpringBootApiServerMockApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApiServerMockApplication.class, args);
    }

}
