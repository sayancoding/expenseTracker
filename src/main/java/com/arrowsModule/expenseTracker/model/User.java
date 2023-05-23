package com.arrowsModule.expenseTracker.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_table")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uId;
    private String username;
    private String password;
}
