package com.example.hexagonal_demo.application.dto;

import com.example.hexagonal_demo.domain.model.Order;

public class OrderMapper {
  private OrderMapper() {}

  public static OrderResponse toResponse(Order order) {
    return new OrderResponse(
            order.getId(),
            order.getDescription(),
            order.isPriority()
    );
  }
}