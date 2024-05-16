package com.backend.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient("fraud")
public interface FraudClient {

    @GetMapping("api/v1/fraud/{customerId}")
    FraudCheckResponse checkFraud(@PathVariable("customerId") UUID customerId);
}
