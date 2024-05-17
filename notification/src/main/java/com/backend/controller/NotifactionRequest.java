package com.backend.controller;

import lombok.Builder;

@Builder
public record NotifactionRequest(
        String customerId,
        String customerEmail,
        String message,
        String sender
) {
}
