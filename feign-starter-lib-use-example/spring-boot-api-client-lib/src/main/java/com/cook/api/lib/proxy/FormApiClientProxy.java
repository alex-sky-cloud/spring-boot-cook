package com.cook.api.lib.proxy;


import com.cook.api.lib.client.RandomJokeClient;
import com.cook.api.lib.model.FormApiClientCommonFormatResponse;
import com.cook.api.lib.model.RandomJokeResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class FormApiClientProxy {
    private final RandomJokeClient randomJokeClient;

    /**
     * Этот api будет доступен приложениям, которые включат создаваемую библиотеку
     * как зависимость.
     *
     * Обратите внимание на тип {@link FormApiClientCommonFormatResponse<RandomJokeResponse>} -
     * это контейнер предоставляет единую модель хранения данных, как для ответа с ошибкой,
     * так и для успешного ответа
     */
    public FormApiClientCommonFormatResponse<RandomJokeResponse> getRandomJoke() {

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

        return FormApiClientCommonFormatResponse.<RandomJokeResponse>builder()
                .data(response)
                .build();
    }


    /**
     * Создадим обработчик ошибок, в случае, если Feign клиент не смог получить response
     * от удаленного сервера
     * @param errorDescription - сообщение об ошибке, которое будет выведено для клиента
     */
    private FormApiClientCommonFormatResponse<RandomJokeResponse> getErrorResponse(String errorDescription) {

        log.info("getRandomJoke request received but an error occurred. Error: {}", errorDescription);

        return FormApiClientCommonFormatResponse.<RandomJokeResponse>builder()
                .error(true)
                .errorDescription(errorDescription)
                .build();
    }
}
