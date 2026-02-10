package com.Assignment.onlineLibrary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Assignment.onlineLibrary.entity.bookIssueEntity;
import com.Assignment.onlineLibrary.entity.userEntity;

public interface BookIssueRepository extends JpaRepository<bookIssueEntity, Long> {

     @Query("""
       SELECT bi.book.category,
              COUNT(bi) * 100.0 / (SELECT COUNT(bi2) FROM BookIssue bi2)
       FROM BookIssue bi
       GROUP BY bi.book.category
    """)
    List<Object[]> categoryReport();
    
    List<bookIssueEntity> findByUser(userEntity user);
}

