package com.example.core.entity;

import com.example.core.autditing.AuditableEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public class BaseObject extends AuditableEntity {

    public static final Long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "native",
            strategy = "native")

    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "native")
    @Column(
            name = "id",
            unique = true,
            nullable = true)
    private Long id;


    @Column(name = "uuid_key", nullable = false)
    @Type(type = "uuid-char")
    private UUID uuid;

    @Column(
            name = "voided",
            nullable = true
    )
    private Boolean voided;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Boolean getVoided() {
        return voided;
    }

    public void setVoided(Boolean voided) {
        this.voided = voided;
    }

    public BaseObject(){
        this.uuid = UUID.randomUUID();
        super.setCreatedDate(LocalDateTime.now());
    }

    public BaseObject (BaseObject object){
        super(object);
        if (object != null){
            this.id = object.getId();
            this.uuid = UUID.randomUUID();
            super.setCreatedDate(LocalDateTime.now());
        }
    }

}
