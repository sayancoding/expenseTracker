package com.arrowsModule.expenseTracker.service.impl;

import com.arrowsModule.expenseTracker.dao.RecordDao;
import com.arrowsModule.expenseTracker.model.Record;
import com.arrowsModule.expenseTracker.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordDao recordDao;
    @Override
    public List<Record> findAll() {
        return recordDao.findAll();
    }

    @Override
    public List<Record> findAllByUid(Long uId) {
        return recordDao.findByUid(uId);
    }

    @Override
    public Record findById(Long id) {
        return recordDao.findById(id).orElseThrow();
    }

    @Override
    public Record findByIdAndUid(Long uId, Long recordId) {
        List<Record> records = recordDao.findByUid(uId);
        Record record = records.stream().filter(e-> e.getRecordId() == recordId).collect(Collectors.toList()).get(0);
        return record;
    }

    @Override
    public String save(Record record) {
        recordDao.save(record);
        return "new record has saved";
    }

    @Override
    public String delete(Long recordId) {
         recordDao.deleteById(recordId);
         return "record has been deleted";
    }
}
