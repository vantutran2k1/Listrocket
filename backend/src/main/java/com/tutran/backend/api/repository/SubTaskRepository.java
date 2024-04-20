package com.tutran.backend.api.repository;

import com.tutran.backend.api.entity.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTaskRepository extends JpaRepository<SubTask, Long> {
}