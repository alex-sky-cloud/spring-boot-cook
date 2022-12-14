package com.cook.mock.controller;

import com.cook.api.lib.model.FormApiClientCommonFormatResponse;
import com.cook.api.lib.model.RandomJokeResponse;
import com.cook.api.lib.proxy.FormApiClientProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestRestController {

    private final FormApiClientProxy formApiClientProxy;

    @GetMapping("api")
    public FormApiClientCommonFormatResponse<RandomJokeResponse> getResponse(){
        return formApiClientProxy.getRandomJoke();
    }

}
