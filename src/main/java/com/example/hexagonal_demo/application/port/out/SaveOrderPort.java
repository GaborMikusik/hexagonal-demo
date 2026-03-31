package com.example.hexagonal_demo.application.port.out;

import com.example.hexagonal_demo.domain.model.Order;

public interface SaveOrderPort {
  Order save(Order order);
}
