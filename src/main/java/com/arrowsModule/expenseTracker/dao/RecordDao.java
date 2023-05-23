package com.arrowsModule.expenseTracker.dao;

import com.arrowsModule.expenseTracker.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecordDao extends JpaRepository<Record,Long> {
    @Query("Select r from Record r Where r.uId = ?1")
    public Optional<List<Record>> findByUid(Long uId);

}
