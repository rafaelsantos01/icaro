package com.mail.icaro.modules.history.repository;

import com.mail.icaro.modules.history.entity.ShippingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShippingHistoryRepository extends JpaRepository<ShippingHistory, UUID> {
}