package com.example.demo.controller;

import com.example.demo.model.ResponseDto;
import com.example.demo.provider.AiAgentProvider;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

class AIControllerTest extends CommonIntegrationTestConfig {
    private static final String URL = "/api/ai";

    @MockitoBean
    AiAgentProvider service;

    @Test
    void should_get_expected_result_when_chat() throws Exception {
        // Given
        ResponseDto expected = ResponseDto.builder().message("Hello, how can I help you?").build();
        Mockito.when(service.ask("Can you help me?")).thenReturn("Hello, how can I help you?");
        // When
        MvcResult mvcResult = mockMvc.perform(getRequest(URL + "/chat?question=Can you help me?"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // Then
        Assertions
                .assertThat(contentToEntity(mvcResult.getResponse().getContentAsString(), ResponseDto.class))
                .usingRecursiveComparison().isEqualTo(expected);
    }
}
