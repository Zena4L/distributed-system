package com.backend.service;

import com.backend.dto.FraudCheckResponse;

import java.util.UUID;

public interface FraudCheckService {

    FraudCheckResponse isFraudulentCustomer(UUID customerId);
}
