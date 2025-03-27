package com.example.demo.provider;

import com.example.demo.aiagent.AiAgentService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DefaultAiAgentProviderTest {

    @Mock
    AiAgentService aiAgentService;

    AiAgentProvider aiAgentProvider;

    @BeforeEach
    void setUp() {
        aiAgentProvider = new DefaultAiAgentProvider(aiAgentService);
    }


    @Test
    void should_call_ask_method() {
        // Given
        var input = "Can you help me?";
        var expected = "Hello, how can I help you?";
        Mockito.when(aiAgentService.chat(ArgumentMatchers.anyString())).thenReturn(expected);
        // When
        var result = aiAgentProvider.ask(input);

        // Then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
