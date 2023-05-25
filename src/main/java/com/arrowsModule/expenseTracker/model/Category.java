package com.arrowsModule.expenseTracker.model;

import javax.persistence.*;

@Entity
@Table(name = "cat_table")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catId;
    private String catName;
    private String type = "exp";
    private Long uId;

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Category(Long catId, String catName, String type, Long uId) {
        this.catId = catId;
        this.catName = catName;
        this.type = type;
        this.uId = uId;
    }
}
