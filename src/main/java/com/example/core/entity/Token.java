package com.example.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "token")
public class Token extends BaseObject{

    @Id
    private UUID id;

    @Column(name = "expired_time")
    private LocalDateTime expiredTime;

    public Token(BaseObject object) {
        super(object);
    }

    public Token(BaseObject object, UUID id, LocalDateTime expiredTime) {
        super(object);
        this.id = id;
        this.expiredTime = expiredTime;
    }


    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(LocalDateTime expiredTime) {
        this.expiredTime = expiredTime;
    }
}
