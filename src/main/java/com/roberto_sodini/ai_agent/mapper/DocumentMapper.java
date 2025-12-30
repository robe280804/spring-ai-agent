package com.roberto_sodini.ai_agent.mapper;

import com.roberto_sodini.ai_agent.dto.DocumentRequestDto;
import com.roberto_sodini.ai_agent.model.DocumentModel;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DocumentMapper {

    public DocumentModel toModel(DocumentRequestDto requestDto){
        return DocumentModel.builder()
                .userId(requestDto.getUserId())
                .name(requestDto.getName())
                .startDate(requestDto.getStartDate())
                .endDate(requestDto.getEndDate())
                .notes(requestDto.getNotes())
                .build();
    }
}
