package com.tutran.backend.api.repository;

import com.tutran.backend.api.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}