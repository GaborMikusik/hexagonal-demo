package com.example.hexagonal_demo.domain.service;

import com.example.hexagonal_demo.domain.model.Order;

public class OrderDomainService {
  public void applyPriorityRule(Order order) {
    if (order.getDescription() != null && order.getDescription().toLowerCase().contains("urgent")) {
      order.markPriority();
    }
  }

  public boolean isImportantEvent(String message) {
    return message != null && message.toLowerCase().contains("important");
  }
}
