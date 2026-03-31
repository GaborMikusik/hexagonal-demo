package com.example.hexagonal_demo.domain.model;

import java.util.UUID;

public class Order {
  private final UUID id;
  private String description;
  private boolean priority;

  public Order(UUID id, String description) {
    this.id = id;
    this.description = description;
    this.priority = false;
  }

  public UUID getId() { return id; }
  public String getDescription() { return description; }

  public void updateDescription(String description) {
    this.description = description;
  }

  public void markPriority() {
    this.priority = true;
  }

  public boolean isPriority() {
    return priority;
  }
}
