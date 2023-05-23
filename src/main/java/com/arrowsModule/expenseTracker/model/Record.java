package com.arrowsModule.expenseTracker.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "record_table")
@Data
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recordId;

    private String note;
    private String extraInfo;
    private Long amount;

    private LocalDateTime updateAt;

    private Long catId;

    private Long uId;
}
