package com.Assignment.onlineLibrary.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.Assignment.onlineLibrary.repository.BookIssueRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final BookIssueRepository bookIssueRepository;

    public Map<String, Double> getCategoryWiseReport() {

        List<Object[]> result = bookIssueRepository.categoryReport();

        Map<String, Double> report = new HashMap<>();

        for (Object[] row : result) {
            String category = (String) row[0];
            Double percentage = (Double) row[1];
            report.put(category, percentage);
        }

        return report;
    }
}
    
