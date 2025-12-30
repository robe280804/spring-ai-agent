package com.roberto_sodini.ai_agent.controller;

import com.roberto_sodini.ai_agent.dto.DocumentRequestDto;
import com.roberto_sodini.ai_agent.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/agent")
@RequiredArgsConstructor
public class AgentController {

    private final DocumentService documentService;

    @PostMapping("/document/add")
    public ResponseEntity<String> addDocument(@RequestBody @Valid DocumentRequestDto requestDto){
        return ResponseEntity.status(201).body(documentService.addDocument(requestDto));
    }
}
