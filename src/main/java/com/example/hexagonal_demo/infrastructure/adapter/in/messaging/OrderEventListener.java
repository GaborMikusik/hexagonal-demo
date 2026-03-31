package com.example.hexagonal_demo.infrastructure.adapter.in.messaging;

import com.example.hexagonal_demo.application.port.in.HandleOrderEventUseCase;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventListener {
  private final HandleOrderEventUseCase useCase;

  public OrderEventListener(HandleOrderEventUseCase useCase) {
    this.useCase = useCase;
  }

  @KafkaListener(topics = "order-events", groupId = "order-group")
  public void handle(String message) {
    useCase.handle(message);
  }
}
