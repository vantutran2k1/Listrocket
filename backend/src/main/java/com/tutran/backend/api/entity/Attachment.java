package com.tutran.backend.api.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "attachments")
@SQLDelete(sql = "UPDATE attachments SET is_deleted = true WHERE id=?")
@SQLRestriction(value = "is_deleted = false")
public class Attachment extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "file_path", columnDefinition = "TEXT NOT NULL", nullable = false)
    private String filePath;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

}
