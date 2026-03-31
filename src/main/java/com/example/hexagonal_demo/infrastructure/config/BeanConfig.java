package com.example.hexagonal_demo.infrastructure.config;

import com.example.hexagonal_demo.application.port.in.CreateOrderUseCase;
import com.example.hexagonal_demo.application.port.in.GetOrderUseCase;
import com.example.hexagonal_demo.application.port.in.HandleOrderEventUseCase;
import com.example.hexagonal_demo.application.port.in.UpdateOrderUseCase;
import com.example.hexagonal_demo.application.port.out.LoadOrderPort;
import com.example.hexagonal_demo.application.port.out.SaveOrderPort;
import com.example.hexagonal_demo.application.port.out.SendEmailPort;
import com.example.hexagonal_demo.application.service.OrderEventService;
import com.example.hexagonal_demo.application.service.OrderService;
import com.example.hexagonal_demo.domain.service.OrderDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
  @Bean
  OrderService orderService(
          SaveOrderPort saveOrderPort,
          LoadOrderPort loadOrderPort,
          OrderDomainService orderDomainService
  ) {
    return new OrderService(saveOrderPort, loadOrderPort, orderDomainService);
  }

  @Bean
  CreateOrderUseCase createOrderUseCase(OrderService orderService) {
    return orderService;
  }

  @Bean
  GetOrderUseCase getOrderUseCase(OrderService orderService) {
    return orderService;
  }

  @Bean
  UpdateOrderUseCase updateOrderUseCase(OrderService orderService) {
    return orderService;
  }

  @Bean
  HandleOrderEventUseCase handleOrderEventUseCase(
          SendEmailPort emailPort,
          OrderDomainService orderDomainService) {
    return new OrderEventService(emailPort, orderDomainService);
  }

  @Bean
  OrderDomainService orderDomainService() {
    return new OrderDomainService();
  }
}
