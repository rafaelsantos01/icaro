package com.mail.icaro.modules.key.entity;

import com.mail.icaro.shared.entity.DateBase;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.UUID;

@Getter
@Setter

@Entity
@Table(name = "key_access")
public class KeyAccess extends DateBase {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid")
    private UUID id;

    @Column(name = "key")
    private String key;

    @Column(name = "service")
    private String service;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "created_at")
    @CreationTimestamp()
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp()
    private Timestamp updatedAt;

}
