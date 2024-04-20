package com.tutran.backend.api.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "notifications")
public class Notification extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "method_name", nullable = false)
    @Enumerated(EnumType.STRING)
    private MethodName methodName;

    @Column(name = "notification_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private NotificationType notificationType;

    @Column(name = "message")
    private String message;

    @Column(name = "scheduled_at", nullable = false)
    LocalDateTime scheduledAt;

    @Column(name = "delivered_at", nullable = false)
    LocalDateTime deliveredAt;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    public enum MethodName {
        EMAIL
    }

    public enum NotificationType {
        REMINDER,
        OVERDUE
    }

    public enum Status {
        SUCCESS,
        FAILED,
        PENDING
    }

}
