package com.roberto_sodini.ai_agent.service;

import com.roberto_sodini.ai_agent.dto.DocumentRequestDto;
import com.roberto_sodini.ai_agent.event.CreateDocumentEvent;
import com.roberto_sodini.ai_agent.mapper.DocumentMapper;
import com.roberto_sodini.ai_agent.model.DocumentModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentMapper documentMapper;
    private final ApplicationEventPublisher eventPublisher;

    public String addDocument(DocumentRequestDto requestDto){
        DocumentModel document = documentMapper.toModel(requestDto);

        // Send event createdocument
        eventPublisher.publishEvent(new CreateDocumentEvent(document));

        // Return response
        return "Your document will be added in few seconds...";
    }
}
