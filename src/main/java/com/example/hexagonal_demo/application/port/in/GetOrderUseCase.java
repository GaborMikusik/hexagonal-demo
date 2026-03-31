package com.example.hexagonal_demo.application.port.in;

import com.example.hexagonal_demo.application.dto.OrderResponse;
import com.example.hexagonal_demo.domain.model.Order;

import java.util.UUID;

public interface GetOrderUseCase {
  OrderResponse getOrder(UUID id);
}