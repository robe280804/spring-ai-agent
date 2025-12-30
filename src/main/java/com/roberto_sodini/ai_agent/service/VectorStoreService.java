package com.roberto_sodini.ai_agent.service;

import com.roberto_sodini.ai_agent.model.DocumentModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class VectorStoreService {

    private final VectorStore vectorStore;

    public void addToVector(DocumentModel documentModel){
            Document document = convertIntoTextDocument(documentModel);
            vectorStore.add(List.of(document));
    }

    private Document convertIntoTextDocument(DocumentModel documentModel){
        StringBuilder text = new StringBuilder();

        // Header (name + date)
        text.append("Document name: ").append(documentModel.getName()).append("\n");
        text.append(String.format(
                "From %s to %s%n",
                documentModel.getStartDate().toString(),
                documentModel.getEndDate().toString()
        ));
        // Notes
        text.append("Notes: ")
                .append(documentModel.getNotes() != null ? documentModel.getNotes() : "N/A")
                .append("\n\n");
        text.append("Entries:\n");

        Document document = new Document(text.toString());

        // Add user_id metadata
        document.getMetadata().put("user_id", documentModel.getUserId());
        return document;
    }
}
