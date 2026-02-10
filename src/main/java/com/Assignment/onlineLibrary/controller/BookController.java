package com.Assignment.onlineLibrary.controller;

import org.springframework.web.bind.annotation.RestController;

import com.Assignment.onlineLibrary.entity.bookEntity;
import com.Assignment.onlineLibrary.service.BookService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<bookEntity> getBooks(@RequestParam(required = false) String category,
                                     @RequestParam(required = false) String author,
                                     @RequestParam(required = false) Boolean available) {
        return bookService.getBooks(category, author, available);
    }

    @PostMapping
    public bookEntity addBook(@RequestBody bookEntity book) {
        return bookService.addBook(book);
    }
}

