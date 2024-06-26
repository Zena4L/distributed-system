package com.backend.controller;


import com.backend.service.FraudCheckService;
import com.clement.fraud.FraudCheckResponse;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/fraud")
public record FraudCheckController(FraudCheckService fraudCheckService) {

    @GetMapping("/{customerId}")
    public FraudCheckResponse checkFraud(@PathVariable("customerId") UUID customerId) {
        return fraudCheckService.isFraudulentCustomer(customerId);

    }
}
