package com.tutran.backend.api.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "subtasks")
@SQLDelete(sql = "UPDATE subtasks SET is_deleted = true WHERE id=?")
@SQLRestriction(value = "is_deleted = false")
public class SubTask extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "completed", columnDefinition = "BOOLEAN DEFAULT FALSE")
    @Builder.Default
    private boolean completed = Boolean.FALSE;

    @Column(name = "due_date")
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private Date dueDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

}
