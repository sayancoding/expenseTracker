package com.arrowsModule.expenseTracker.dao;

import com.arrowsModule.expenseTracker.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends JpaRepository<Category,Long> {
    @Query("SELECT c from Category c WHERE c.uId = ?1")
    List<Category> findAllByUserId(Long uId);
}
