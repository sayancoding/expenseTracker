package com.arrowsModule.expenseTracker.service.impl;

import com.arrowsModule.expenseTracker.dao.RecordDao;
import com.arrowsModule.expenseTracker.exception.NotFoundException;
import com.arrowsModule.expenseTracker.model.Record;
import com.arrowsModule.expenseTracker.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Record> findAllByUid(Long uId) throws NotFoundException {
        return recordDao.findByUid(uId)
                .orElseThrow(()-> new NotFoundException("No such user"));
    }

    @Override
    public Record findById(Long id) throws NotFoundException {
        return recordDao.findById(id).orElseThrow(()-> new NotFoundException("No such records"));
    }

    @Override
    public Record findByIdAndUid(Long uId, Long recordId) throws NotFoundException {
        List<Record> records = recordDao.findByUid(uId).orElseThrow(()-> new NotFoundException("No such user"));
        List<Record> filterRecord = records.stream().filter(e-> e.getRecordId() == recordId).collect(Collectors.toList());
        if(filterRecord != null && filterRecord.size() > 0) return filterRecord.get(0);
        else throw new NotFoundException("No such record");
    }

    @Override
    public String save(Record record) {
        recordDao.save(record);
        return "new record has saved";
    }

    @Override
    public String delete(Long recordId) throws NotFoundException {
        Record record = recordDao.findById(recordId).orElseThrow(()-> new NotFoundException("No such record"));
        recordDao.delete(record);
        return "record has been deleted";
    }
}
