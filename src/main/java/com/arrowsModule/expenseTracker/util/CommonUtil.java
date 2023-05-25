package com.arrowsModule.expenseTracker.util;


import com.arrowsModule.expenseTracker.model.Category;
import com.arrowsModule.expenseTracker.model.Record;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommonUtil {

    public static Category parseToCategory(String data){
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        om.registerModule(new JavaTimeModule());
        try{
            return om.readValue(data, Category.class);
        }catch (Exception ex){
            log.info(ex.getMessage());
        }
        return null;
    }
    public static String categoryToString(Category category){
        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());
        try{
            return om.writeValueAsString(category);
        }catch (Exception ex){
            log.info(ex.getMessage());
        }
        return null;
    }
    public static Record parseToRecord(String data){
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        om.registerModule(new JavaTimeModule());
        try{
            return om.readValue(data, Record.class);
        }catch (Exception ex){
            log.info(ex.getMessage());
        }
        return null;
    }
    public static String recordToString(Record record){
        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());
        try{
            return om.writeValueAsString(record);
        }catch (Exception ex){
            log.info(ex.getMessage());
        }
        return null;
    }
}
