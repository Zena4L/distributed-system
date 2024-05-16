package com.backend.repository;

import com.backend.model.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, UUID> {
}
