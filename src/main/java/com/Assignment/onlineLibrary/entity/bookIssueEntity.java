package com.Assignment.onlineLibrary.entity;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "BookIssue")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class bookIssueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate issueDate;
    private LocalDate returnDate;

    private boolean returned;

    @ManyToOne
    private userEntity user;

    @ManyToOne
    private bookEntity book;
}

