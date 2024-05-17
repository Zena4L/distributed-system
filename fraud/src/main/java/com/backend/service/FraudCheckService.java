package com.backend.service;




import com.clement.fraud.FraudCheckResponse;

import java.util.UUID;

public interface FraudCheckService {

    FraudCheckResponse isFraudulentCustomer(UUID customerId);
}
