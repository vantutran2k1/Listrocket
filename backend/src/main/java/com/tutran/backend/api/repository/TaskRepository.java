package com.tutran.backend.api.repository;

import com.tutran.backend.api.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}