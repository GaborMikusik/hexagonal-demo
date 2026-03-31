package com.example.hexagonal_demo.application.service;

import com.example.hexagonal_demo.application.dto.OrderMapper;
import com.example.hexagonal_demo.application.dto.OrderResponse;
import com.example.hexagonal_demo.application.port.in.CreateOrderUseCase;
import com.example.hexagonal_demo.application.port.in.GetOrderUseCase;
import com.example.hexagonal_demo.application.port.in.UpdateOrderUseCase;
import com.example.hexagonal_demo.application.port.out.LoadOrderPort;
import com.example.hexagonal_demo.application.port.out.SaveOrderPort;
import com.example.hexagonal_demo.domain.model.Order;
import com.example.hexagonal_demo.domain.service.OrderDomainService;

import java.util.UUID;

public class OrderService implements CreateOrderUseCase, GetOrderUseCase, UpdateOrderUseCase {

  private final SaveOrderPort saveOrderPort;
  private final LoadOrderPort loadOrderPort;
  private final OrderDomainService orderDomainService;

  public OrderService(
          SaveOrderPort saveOrderPort,
          LoadOrderPort loadOrderPort,
          OrderDomainService orderDomainService
  ) {
    this.saveOrderPort = saveOrderPort;
    this.loadOrderPort = loadOrderPort;
    this.orderDomainService = orderDomainService;
  }

  @Override
  public UUID createOrder(String description) {
    Order order = new Order(UUID.randomUUID(), description);

    orderDomainService.applyPriorityRule(order);

    return saveOrderPort.save(order).getId();
  }

  @Override
  public OrderResponse getOrder(UUID id) {
    Order order = loadOrderPort.load(id)
            .orElseThrow(() -> new RuntimeException("Order not found"));
    return OrderMapper.toResponse(order);
  }

  @Override
  public void updateOrder(UUID id, String description) {
    Order order = loadOrderPort.load(id)
            .orElseThrow(() -> new RuntimeException("Order not found"));

    order.updateDescription(description);

    orderDomainService.applyPriorityRule(order);

    saveOrderPort.save(order);
  }
}