package com.example.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "token")
public class Token extends EntityObject{

    @Column(name = "expired_time")
    private LocalDateTime expiredTime;

    public Token(BaseObject object) {
        super(object);
    }

    public Token() {

    }

    public Token(BaseObject object, UUID id, LocalDateTime expiredTime) {
        super(object);
        this.expiredTime = expiredTime;
    }

    public LocalDateTime getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(LocalDateTime expiredTime) {
        this.expiredTime = expiredTime;
    }
}
