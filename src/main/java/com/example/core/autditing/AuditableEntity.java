package com.example.core.autditing;

import com.example.core.entity.BaseObject;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
@EntityListeners({EntityListeners.class})
public class AuditableEntity implements Serializable {

    @Transient
    public static final long serialVersionUID = 1L;

    @Column(name = "create_date",
            nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "create_by", nullable = true)
    private String createBy;

    @Column(name = "modify_date", nullable = true)
    private LocalDateTime modifyDate;

    @Column(name = "modify_by", nullable = true)
    private String modifyBy;

    public LocalDateTime getCreatedDate(){
        return this.createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate){
        this.createdDate = createdDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public AuditableEntity() {
    }

    public AuditableEntity(AuditableEntity entity) {
        this.createdDate = entity.getCreatedDate();
        this.createBy = entity.getCreateBy();
        this.modifyDate = entity.getModifyDate();
        this.modifyBy = entity.getModifyBy();
    }
}
