package com.example.demo.controller;

import com.example.demo.model.ResponseDto;
import com.example.demo.provider.AiAgentProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
public class AIController {

    private final AiAgentProvider aiAgentProvider;

    @GetMapping("/chat")
    public ResponseEntity<ResponseDto> chat(@RequestParam String question) {
        return ResponseEntity.ok().body(ResponseDto.builder().message(aiAgentProvider.ask(question)).build());
    }
}