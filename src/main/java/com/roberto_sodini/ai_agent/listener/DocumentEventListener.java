package com.roberto_sodini.ai_agent.listener;

import com.roberto_sodini.ai_agent.event.CreateDocumentEvent;
import com.roberto_sodini.ai_agent.repository.DocumentRepository;
import com.roberto_sodini.ai_agent.service.VectorStoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class DocumentEventListener {

    private final VectorStoreService vectorStoreService;
    private final DocumentRepository documentRepository;

    /**
     *
     * @param documentEvent
     */
    @EventListener
    public void handle(CreateDocumentEvent documentEvent){
        try {
            vectorStoreService.addToVector(documentEvent.documentModel());
            documentRepository.save(documentEvent.documentModel());
        } catch (Exception ex){
            log.error("[DOCUMENT_LISTENER] Error: {}", ex.getMessage());
        }
    }
}
