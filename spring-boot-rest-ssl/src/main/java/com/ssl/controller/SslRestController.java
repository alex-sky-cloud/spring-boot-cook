package com.ssl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ssl")
public class SslRestController {

    @GetMapping("{name}")
    public String getValidationEndpoint(@PathVariable String name){

        return "Hello " + name + "!";
    }
}
