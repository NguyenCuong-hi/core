package com.example.core.entity;

import com.example.core.autditing.AuditableEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public class EntityObject extends AuditableEntity {

    public static final Long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "native",
            strategy = "native")
    @Column(
            name = "id",
            unique = true,
            nullable = true)
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public EntityObject() {
        this.id = UUID.randomUUID();
        super.setCreatedDate(LocalDateTime.now());
    }

    public EntityObject(AuditableEntity entity) {
        super(entity);
        this.id = UUID.randomUUID();
        super.setCreatedDate(LocalDateTime.now());
    }
}
