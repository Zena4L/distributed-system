package com.backend.fraud;

import lombok.Builder;

@Builder
public record FraudCheckResponse(Boolean isFraudster) {
}