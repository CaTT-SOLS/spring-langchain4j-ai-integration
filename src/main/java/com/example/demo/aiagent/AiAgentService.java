package com.example.demo.aiagent;

import dev.langchain4j.service.spring.AiService;

@AiService
public interface AiAgentService {
    String chat(String userMessage);
}
