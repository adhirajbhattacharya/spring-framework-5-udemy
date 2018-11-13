package com.adhiraj.spring5.service;

// @Service
// @Profile("es")
// @Primary
public class SpanishPrimaryGreetingService implements GreetingService {

  @Override
  public String sayGreeting() {
    return "HOLA GURU - Primary Spanish";
  }

}
