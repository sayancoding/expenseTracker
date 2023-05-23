package com.arrowsModule.expenseTracker.dao;

import com.arrowsModule.expenseTracker.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordDao extends JpaRepository<Record,Long> {
}
