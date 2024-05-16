package com.backend.service;


import com.backend.fraud.FraudCheckResponse;

import java.util.UUID;

public interface FraudCheckService {

    FraudCheckResponse isFraudulentCustomer(UUID customerId);
}
