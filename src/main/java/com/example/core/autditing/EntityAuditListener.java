package com.example.core.autditing;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class EntityAuditListener {

    public EntityAuditListener(){

    }

    @PrePersist
    public void prePersist(AuditableEntity auditableEntity){
        LocalDateTime now = LocalDateTime.now();
        auditableEntity.setCreatedDate(now);
        auditableEntity.setModifyDate(now);

        auditableEntity.setCreateBy("UNKNOWN");
        auditableEntity.setModifyBy("UNKNOWN");
    }


    @PreUpdate
    public void preUpdate(AuditableEntity auditableEntity){
        LocalDateTime now = LocalDateTime.now();
        auditableEntity.setModifyDate(now);

        auditableEntity.setModifyBy("UNKNOWN");
    }



}
