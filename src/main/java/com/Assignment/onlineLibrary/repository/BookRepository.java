package com.Assignment.onlineLibrary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Assignment.onlineLibrary.entity.bookEntity;

public interface BookRepository extends JpaRepository<bookEntity, Long> {

    List<bookEntity> findByCategory(String category);
    List<bookEntity> findByAuthor(String author);
    List<bookEntity> findByAvailable(boolean available);
}

