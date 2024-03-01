package com.example.retry.controller;

import com.example.retry.domain.Book;
import com.example.retry.exception.SaveBookException;
import com.example.retry.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("v1")
    public String saveTodo(@RequestBody Book book) throws SaveBookException, IllegalArgumentException {
        return bookService.saveTodo(book);
    }
}
