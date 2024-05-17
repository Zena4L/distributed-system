package com.backend.service;

import com.backend.model.FraudCheckHistory;
import com.backend.repository.FraudCheckHistoryRepository;
import com.clement.fraud.FraudCheckResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class FraudCheckServiceImpl implements FraudCheckService {

    private final FraudCheckHistoryRepository repository;

    @Override
    public FraudCheckResponse isFraudulentCustomer(UUID customerId) {
        FraudCheckHistory history = FraudCheckHistory.builder()
                .customerId(customerId)
                .isFraudster(false)
                .build();
        repository.save(history);
        return FraudCheckResponse.builder().isFraudster(false).build();
    }
}
