package com.example.demo.provider;

import com.example.demo.aiagent.AiAgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultAiAgentProvider implements AiAgentProvider{

    private final AiAgentService aIAgentService;

    @Override
    public String ask(String question) {
        return aIAgentService.chat(question);
    }
}
