package com.backend.dto;

import lombok.Builder;

@Builder
public record FraudCheckResponse(Boolean isFraudster) {
}
