package com.arrowsModule.expenseTracker.service;

import com.arrowsModule.expenseTracker.model.Record;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RecordService {
    public List<Record> findAll();
    public Record findById(Long id);
    public String save(Record record);

}
