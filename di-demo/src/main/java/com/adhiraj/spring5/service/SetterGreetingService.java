package com.adhiraj.spring5.service;

import org.springframework.stereotype.Service;

@Service
public class SetterGreetingService implements GreetingService {

  @Override
  public String sayGreeting() {
    return "HELLO GURU - Inject by setter";
  }

}
