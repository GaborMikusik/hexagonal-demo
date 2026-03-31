package com.example.hexagonal_demo.infrastructure.adapter.out.persistence;

import com.example.hexagonal_demo.application.port.out.LoadOrderPort;
import com.example.hexagonal_demo.application.port.out.SaveOrderPort;
import com.example.hexagonal_demo.domain.model.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class OrderPersistenceAdapter implements LoadOrderPort, SaveOrderPort {

  private final SpringDataOrderRepository repository;

  public OrderPersistenceAdapter(SpringDataOrderRepository repository) {
    this.repository = repository;
  }


  @Override
  public Optional<Order> load(UUID id) {
    return repository.findById(id)
            .map(e -> {
              Order order = new Order(e.getId(), e.getDescription());
              if (e.isPriority()) order.markPriority();
              return order;
            });
  }

  @Override
  public Order save(Order order) {
    OrderEntity entity = new OrderEntity();
    entity.setId(order.getId());
    entity.setDescription(order.getDescription());
    entity.setPriority(order.isPriority());
    repository.save(entity);
    return order;
  }
}
