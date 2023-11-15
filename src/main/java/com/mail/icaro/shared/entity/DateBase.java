package com.mail.icaro.shared.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@MappedSuperclass
public class DateBase {

    @Column(name = "created_at")
    @CreationTimestamp()
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp()
    private Timestamp updatedAt;

}
