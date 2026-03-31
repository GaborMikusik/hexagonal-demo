package com.example.hexagonal_demo.application.port.in;

import java.util.UUID;

public interface UpdateOrderUseCase {
  void updateOrder(UUID id, String description);
}
