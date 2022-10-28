package com.cook.api.lib.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Модель для хранения данных по единому шаблону.
 * Данная модель будет наполняться данными,
 * которые описывают ошибку, произошедшую, при попытке
 * получить данные из удаленной системы или же наполняется данными, которые
 * были успешно получены из удаленной системы
 * @param <T>
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FormApiClientCommonFormatResponse<T> {
    private T data;
    private boolean error;
    private String errorDescription;
}
