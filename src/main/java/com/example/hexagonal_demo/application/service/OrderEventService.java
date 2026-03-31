package com.example.hexagonal_demo.application.service;

import com.example.hexagonal_demo.application.port.in.HandleOrderEventUseCase;
import com.example.hexagonal_demo.application.port.out.SendEmailPort;
import com.example.hexagonal_demo.domain.service.OrderDomainService;

public class OrderEventService implements HandleOrderEventUseCase {
  private final SendEmailPort emailPort;
  private final OrderDomainService orderDomainService;

  public OrderEventService(
          SendEmailPort emailPort,
          OrderDomainService domainService
  ) {
    this.emailPort = emailPort;
    this.orderDomainService = domainService;
  }

  @Override
  public void handle(String message) {

    // domain decides
    if (orderDomainService.isImportantEvent(message)) {
      emailPort.send(
              "admin@example.com",
              "Important Order Event",
              message
      );
    }
  }
}
