package com.example.hexagonal_demo.domain.repository;

import com.example.hexagonal_demo.domain.model.Order;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {
  Order save(Order order);

  Optional<Order> findById(UUID id);
}
