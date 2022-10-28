package com.cook.api.lib.proxy;


import com.cook.api.lib.client.RandomJokeClient;
import com.cook.api.lib.model.FormApiClientResponse;
import com.cook.api.lib.model.RandomJokeResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class FormApiClientProxy {
    private final RandomJokeClient randomJokeClient;

    public FormApiClientResponse<RandomJokeResponse> getRandomJoke() {
        RandomJokeResponse response;

        try {
            response = randomJokeClient.getRandomJoke();
        } catch (Exception exception) {
            return getErrorResponse(exception.getMessage());
        }

        if (response == null) {
            return getErrorResponse("RandomJokeClient returned null response!");
        }

        log.info("getRandomJoke request received. Response: {}", response);

        return FormApiClientResponse.<RandomJokeResponse>builder()
                .data(response)
                .build();
    }

    private FormApiClientResponse<RandomJokeResponse> getErrorResponse(String errorDescription) {

        log.info("getRandomJoke request received but an error occurred. Error: {}", errorDescription);

        return FormApiClientResponse.<RandomJokeResponse>builder()
                .error(true)
                .errorDescription(errorDescription)
                .build();
    }
}
