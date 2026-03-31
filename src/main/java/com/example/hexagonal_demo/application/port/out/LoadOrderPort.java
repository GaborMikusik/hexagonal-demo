package com.example.hexagonal_demo.application.port.out;

import com.example.hexagonal_demo.domain.model.Order;

import java.util.Optional;
import java.util.UUID;

public interface LoadOrderPort {
  Optional<Order> load(UUID id);
}

