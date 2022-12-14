package com.cook.api.lib.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Модель с данными, в которую будет "разбираться" response,
 * полученный через Feign-клиент, от удаленного сервера
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RandomJokeResponse {
    private int id;
    private String type;
    private String setup;
    private String punchline;
}
