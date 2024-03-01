package com.example.retry.service;


import com.example.retry.domain.Book;
import com.example.retry.exception.SaveBookException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookService {

    @Retryable(retryFor = {
            SaveBookException.class,
            IllegalArgumentException.class
    },
            maxAttempts = 1,
            backoff = @Backoff(delay = 800)
    )
    public String saveTodo(Book book) throws SaveBookException, IllegalArgumentException {

        if (book.getContent().equals("SaveTodoException")) {

            log.error("Error when todo saving. [SaveTodoException]");

            throw new SaveBookException("Todo did not save");

        }
        else if (
                book.getContent().equals("IllegalArgumentException")
        ) {
            log.error("Error when todo saving. [IllegalArgumentException]");
            throw new IllegalArgumentException("Todo did not save");
        }

        return "todo saved.";
    }

    /**
     Аннотация @Recover позволяет определить fallback метод,
     который будет вызван, когда все попытки повторных попыток,
     настроенные с помощью @Retryable, будут исчерпаны.
     Fallback метод предназначен для выполнения альтернативной логики,
     такой как: отправка сообщения об ошибке,
     попытка подключения к резервной службе или обновление состояния приложения для отражения сбоя.
     */
    @Recover
    public String recoverSaveTodo(SaveBookException e, Book book) {
        log.info(book.getContent());

        return "recover save todo [SaveTodoException]";
    }

   @Recover
    public String recoverSaveTodo(IllegalArgumentException e, Book book) {

        log.info(book.getContent());

        return "recover save todo [IllegalArgumentException1]";
    }
}
