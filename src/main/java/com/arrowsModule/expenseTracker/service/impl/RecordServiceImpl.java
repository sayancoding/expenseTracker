package com.arrowsModule.expenseTracker.service.impl;

import com.arrowsModule.expenseTracker.dao.RecordDao;
import com.arrowsModule.expenseTracker.model.Record;
import com.arrowsModule.expenseTracker.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordDao recordDao;
    @Override
    public List<Record> findAll() {
        return recordDao.findAll();
    }

    @Override
    public Record findById(Long id) {
        return recordDao.findById(id).orElseThrow();
    }

    @Override
    public String save(Record record) {
        recordDao.save(record);
        return "new record has saved";
    }
}
