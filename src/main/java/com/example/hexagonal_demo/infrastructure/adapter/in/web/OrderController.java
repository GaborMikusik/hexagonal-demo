package com.example.hexagonal_demo.infrastructure.adapter.in.web;

import com.example.hexagonal_demo.application.dto.OrderResponse;
import com.example.hexagonal_demo.application.port.in.CreateOrderUseCase;
import com.example.hexagonal_demo.application.port.in.GetOrderUseCase;
import com.example.hexagonal_demo.application.port.in.UpdateOrderUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

  private final CreateOrderUseCase createOrderUseCase;
  private final GetOrderUseCase getOrderUseCase;
  private final UpdateOrderUseCase updateOrderUseCase;

  public OrderController(
          CreateOrderUseCase createOrderUseCase,
          GetOrderUseCase getOrderUseCase,
          UpdateOrderUseCase updateOrderUseCase
  ) {
    this.createOrderUseCase = createOrderUseCase;
    this.getOrderUseCase = getOrderUseCase;
    this.updateOrderUseCase = updateOrderUseCase;
  }

  @PostMapping
  public UUID create(@RequestBody String description) {
    return createOrderUseCase.createOrder(description);
  }

  @GetMapping("/{id}")
  public OrderResponse get(@PathVariable UUID id) {
    return getOrderUseCase.getOrder(id);
  }

  @PutMapping("/{id}")
  public void update(@PathVariable UUID id, @RequestBody String description) {
    updateOrderUseCase.updateOrder(id, description);
  }
}
