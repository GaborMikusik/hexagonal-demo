package com.example.hexagonal_demo.application.dto;

import java.util.UUID;

public record OrderResponse(UUID id, String description, boolean priority) {
}
