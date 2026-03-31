package com.example.hexagonal_demo.infrastructure.adapter.out.email;

import com.example.hexagonal_demo.application.port.out.SendEmailPort;
import org.springframework.stereotype.Component;

@Component
public class EmailAdapter implements SendEmailPort {

  @Override
  public void send(String to, String subject, String body) {
    System.out.println("Sending email to " + to);
    System.out.println("Subject: " + subject);
    System.out.println("Body: " + body);
  }
}