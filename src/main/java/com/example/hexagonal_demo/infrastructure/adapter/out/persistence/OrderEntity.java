package com.example.hexagonal_demo.infrastructure.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class OrderEntity {

  @Id
  private UUID id;
  private String description;
  private boolean priority;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setPriority(boolean priority) {
    this.priority = priority;
  }

  public boolean isPriority() {
    return priority;
  }
}
