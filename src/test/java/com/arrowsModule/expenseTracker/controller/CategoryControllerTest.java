package com.arrowsModule.expenseTracker.controller;

import com.arrowsModule.expenseTracker.dao.CategoryDao;
import com.arrowsModule.expenseTracker.model.Category;
import com.arrowsModule.expenseTracker.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CategoryControllerTest {
    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @MockBean
    CategoryDao categoryDao;

    Category category1;
    Category category2;

    @BeforeAll
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();

        category1 = new Category(Long.valueOf(10),"food","exp",Long.valueOf(12));
        category2 = new Category(Long.valueOf(11),"others","exp",Long.valueOf(10));
    }
    @Test()
    void findAll() throws Exception {

        when(categoryDao.findAll()).thenReturn(
                Arrays.asList(category1,category2));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/cat"))
                .andDo(print())
                .andExpect(status().isOk()).andReturn();
        log.info(result.getResponse().getContentAsString());
    }
    @Test()
    void findByUserId() throws Exception {

        when(categoryDao.findAllByUserId(12L)).thenReturn(
               Optional.of(Arrays.asList(category1)));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/cat?uid=12"))
                .andDo(print())
                .andExpect(status().isOk()).andReturn();
        log.info(result.getResponse().getContentAsString());
    }

    @Test
    void save() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/cat")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(CommonUtil.categoryToString(category1)))
                        .andExpect(status().isCreated()).andReturn();
    }

}
