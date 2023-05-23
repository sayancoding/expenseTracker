package com.arrowsModule.expenseTracker.service;

import com.arrowsModule.expenseTracker.exception.NotFoundException;
import com.arrowsModule.expenseTracker.model.Record;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RecordService {
    public List<Record> findAll();
    public List<Record> findAllByUid(Long uId) throws NotFoundException;
    public Record findById(Long id) throws NotFoundException;
    public Record findByIdAndUid(Long uId,Long recordId) throws NotFoundException;
    public String save(Record record);
    public String delete(Long recordId) throws NotFoundException;
}
