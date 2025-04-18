package com.loans.calculator.task.api;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class LoansControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;


    @ParameterizedTest
    @CsvSource({"null,6,36", " ,6,36", ",6,36", "-1,6,36", "0,6,36", "100,-5,36", "100,6,-10", "100,6,0"})
    void calculateLoanSchedule(String amount, String interestRate, String term) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/loans/schedule/annual")
                .param("amount", amount)
                .param("interestRate", interestRate)
                .param("term", term))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}