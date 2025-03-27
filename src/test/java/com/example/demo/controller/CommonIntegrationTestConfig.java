package com.example.demo.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@AiAgentIntegrationTest
public class CommonIntegrationTestConfig {

    @Autowired
    protected MockMvc mockMvc;

    protected ObjectMapper objectMapper = new ObjectMapper();

    protected <T> T contentToEntity(String content, Class<T> clazz) throws JsonProcessingException {
        return objectMapper.readValue(content, clazz);
    }

    protected MockHttpServletRequestBuilder getRequest(String url) {
        return MockMvcRequestBuilders.get(url, new Object[0])
                .accept(new String[]{MediaType.APPLICATION_JSON_VALUE})
                .contentType(MediaType.APPLICATION_JSON);
    }
}
