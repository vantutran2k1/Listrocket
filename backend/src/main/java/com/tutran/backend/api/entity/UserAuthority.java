package com.tutran.backend.api.entity;

import com.tutran.backend.api.converter.AuthorityTypeEnumConverter;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "user_authorities")
public class UserAuthority extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false)
    @Convert(converter = AuthorityTypeEnumConverter.class)
    private AuthorityType name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public enum AuthorityType {
        ADMIN,
        USER
    }

}
