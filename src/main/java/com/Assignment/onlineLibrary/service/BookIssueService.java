package com.Assignment.onlineLibrary.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Assignment.onlineLibrary.entity.bookEntity;
import com.Assignment.onlineLibrary.entity.bookIssueEntity;
import com.Assignment.onlineLibrary.entity.userEntity;
import com.Assignment.onlineLibrary.repository.BookIssueRepository;
import com.Assignment.onlineLibrary.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookIssueService {

    private final BookIssueRepository issueRepository;
    private final BookRepository bookRepository;
    private final UserService userService;

    // 7️⃣ Issue Book (membership check)
    public String issueBook(userEntity user, bookEntity book, int days) {

        if (!userService.isMembershipValid(user)) {
            return "Membership expired. Please renew.";
        }

        if (!book.isAvailable()) {
            return "Book already taken.";
        }

        book.setAvailable(false);
        bookRepository.save(book);

        bookIssueEntity issue = new bookIssueEntity();
        issue.setUser(user);
        issue.setBook(book);
        issue.setIssueDate(LocalDate.now());
        issue.setReturnDate(LocalDate.now().plusDays(days));
        issue.setReturned(false);

        issueRepository.save(issue);
        return "Book issued successfully";
    }

    // 5️⃣ Return Book
    public void returnBook(bookIssueEntity issue) {
        issue.setReturned(true);
        issue.getBook().setAvailable(true);
        issueRepository.save(issue);
    }

    // 8️⃣ User history
    public List<bookIssueEntity> getUserHistory(userEntity user) {
        return issueRepository.findByUser(user);
    }
    public bookIssueEntity getIssueById(Long id) {
    return issueRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Issue not found"));
}

}

