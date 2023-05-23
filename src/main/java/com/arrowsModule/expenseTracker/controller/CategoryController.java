package com.arrowsModule.expenseTracker.controller;

import com.arrowsModule.expenseTracker.dto.Response;
import com.arrowsModule.expenseTracker.model.Category;
import com.arrowsModule.expenseTracker.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/cat")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping()
    ResponseEntity<Response> save(@RequestBody Category category, HttpServletRequest request){
        String res = categoryService.save(category);
        Response response = new Response(request.getRequestURI(), res, HttpStatus.CREATED.value(),HttpStatus.CREATED.name() );
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @GetMapping()
    ResponseEntity<Response> findAll(@RequestParam(name = "uid",required = false) String uId,HttpServletRequest request){
        List<Category> res;
        if(uId != null && !uId.trim().isEmpty()){
            res = categoryService.findAllByUserId(Long.valueOf(uId));
        }else{
            res = categoryService.findAll();
        }
        Response response = new Response(request.getRequestURI(), res, HttpStatus.OK.value(),HttpStatus.OK.name());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @DeleteMapping("/{catId}")
    ResponseEntity<Response> deleteById(@RequestParam Long catId,HttpServletRequest request){
        String res = categoryService.delete(catId);
        Response response = new Response(request.getRequestURI(), res, HttpStatus.OK.value(),HttpStatus.OK.name() );
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
