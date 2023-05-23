package com.arrowsModule.expenseTracker.controller;

import com.arrowsModule.expenseTracker.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rec")
public class RecordController {
    @Autowired
    RecordService recordService;
}
