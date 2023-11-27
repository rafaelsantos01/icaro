package com.mail.icaro.modules.key.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface KeyAccessRepository extends JpaRepository<KeyAccess, UUID> {
    KeyAccess findByKeyAndStatusTrue(String key);

    KeyAccess findByKey(String key);
}