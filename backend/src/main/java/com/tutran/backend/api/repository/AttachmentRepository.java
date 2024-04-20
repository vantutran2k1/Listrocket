package com.tutran.backend.api.repository;

import com.tutran.backend.api.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
}