package com.Assignment.onlineLibrary.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Assignment.onlineLibrary.service.ReportService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    // 9️⃣ Category-wise reading percentage
    @GetMapping("/category")
    public Map<String, Double> categoryReport() {
        return reportService.getCategoryWiseReport();
    }
}
    

