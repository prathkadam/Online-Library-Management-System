package com.Assignment.onlineLibrary.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Assignment.onlineLibrary.entity.bookEntity;
import com.Assignment.onlineLibrary.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    // 2️⃣ Get books with filters
    public List<bookEntity> getBooks(String category, String author, Boolean available) {
        if (category != null) return bookRepository.findByCategory(category);
        if (author != null) return bookRepository.findByAuthor(author);
        if (available != null) return bookRepository.findByAvailable(available);
        return bookRepository.findAll();
    }

    // 4️⃣ Add Book
    public bookEntity addBook(bookEntity book) {
        return bookRepository.save(book);
    }
}

