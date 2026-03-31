package com.example.hexagonal_demo.application.port.out;

public interface SendEmailPort {
  void send(String to, String subject, String body);
}
