package com.arrowsModule.expenseTracker.controller;

import com.arrowsModule.expenseTracker.dto.Response;
import com.arrowsModule.expenseTracker.exception.NotFoundException;
import com.arrowsModule.expenseTracker.model.Record;
import com.arrowsModule.expenseTracker.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/record")
public class RecordController {
    @Autowired
    RecordService recordService;

    @GetMapping()
    ResponseEntity<Response> getRecord(@RequestParam(name = "uid",required = false) String uId,
                                       @RequestParam(name = "rid",required = false) String rId,
                                       HttpServletRequest request) throws NotFoundException {
        List<Record> records;
        Record record = null;
        if(uId != null && !uId.trim().isEmpty()){
            records = recordService.findAllByUid(Long.valueOf(uId));
        }else{
            records = recordService.findAll();
        }

        if(rId != null && !rId.trim().isEmpty()){
            List<Record> filterRecord = records.stream().filter(e->e.getRecordId() == Long.valueOf(rId))
                    .collect(Collectors.toList());
            if(filterRecord != null && filterRecord.size() > 0){
                Response response = Response.builder()
                        .path(request.getRequestURI())
                        .content(filterRecord.get(0))
                        .httpCode(HttpStatus.OK.value())
                        .httpMessage(HttpStatus.OK.getReasonPhrase())
                        .build();
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            else{
                throw new NotFoundException("no such record");
            }
        }
        Response response = Response.builder()
                .path(request.getRequestURI())
                .content(records)
                .httpCode(HttpStatus.OK.value())
                .httpMessage(HttpStatus.OK.getReasonPhrase())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<Response> save(@RequestBody Record record, HttpServletRequest request) {
        String res = recordService.save(record);
        Response response = Response.builder()
                .path(request.getRequestURI())
                .content(res)
                .httpCode(HttpStatus.OK.value())
                .httpMessage(HttpStatus.OK.getReasonPhrase())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
