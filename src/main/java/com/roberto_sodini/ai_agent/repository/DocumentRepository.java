package com.roberto_sodini.ai_agent.repository;

import com.roberto_sodini.ai_agent.model.DocumentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<DocumentModel, Long> {
}
