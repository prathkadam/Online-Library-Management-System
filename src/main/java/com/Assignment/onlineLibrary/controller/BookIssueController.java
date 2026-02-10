package com.Assignment.onlineLibrary.controller;

import com.Assignment.onlineLibrary.entity.bookEntity;
import com.Assignment.onlineLibrary.entity.bookIssueEntity;
import com.Assignment.onlineLibrary.entity.userEntity;
import com.Assignment.onlineLibrary.repository.BookRepository;
import com.Assignment.onlineLibrary.repository.UserRepository;
import com.Assignment.onlineLibrary.service.BookIssueService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/issues")
@RequiredArgsConstructor
public class BookIssueController {

    private final BookIssueService bookIssueService;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    // 7️⃣ Issue book (membership check inside service)
    @PostMapping("/issue")
    public String issueBook(@RequestParam Long userId,
                            @RequestParam Long bookId,
                            @RequestParam int days) {

        userEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        bookEntity book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        return bookIssueService.issueBook(user, book, days);
    }

    // 5️⃣ Return book
    @PostMapping("/return/{issueId}")
    public String returnBook(@PathVariable Long issueId) {

        bookIssueEntity issue = bookIssueService.getIssueById(issueId);
        bookIssueService.returnBook(issue);

        return "Book returned successfully";
    }

    // 8️⃣ User book history (past + current)
    @GetMapping("/user/{userId}")
    public List<bookIssueEntity> getUserHistory(@PathVariable Long userId) {

        userEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return bookIssueService.getUserHistory(user);
    }
}

    

