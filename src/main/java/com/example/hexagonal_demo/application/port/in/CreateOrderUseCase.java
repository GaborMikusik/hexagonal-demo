package com.example.hexagonal_demo.application.port.in;

import java.util.UUID;

public interface CreateOrderUseCase {
  UUID createOrder(String description);
}