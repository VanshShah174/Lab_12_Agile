package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NumberController.class)
public class NumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testDoubleNumberEndpoint() throws Exception {
        int inputNumber = 5;

        // Perform a GET request to the "/double" endpoint with the number as a parameter
        mockMvc.perform(get("/double")
                        .param("number", String.valueOf(inputNumber))
                        .contentType(MediaType.APPLICATION_JSON))
                // Verify that the response status is OK
                .andExpect(status().isOk())
                // Verify that the response content type is JSON
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                // Verify that the response body contains the expected doubled value
                .andExpect(content().string(containsString("8")));
    }
}
