package com.backend.dto;

import lombok.Builder;

@Builder
public record CustomerRequest(
        String firstname,
        String lastname,
        String email
) {
}
