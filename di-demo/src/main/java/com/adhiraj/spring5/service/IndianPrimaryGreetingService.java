package com.adhiraj.spring5.service;

// @Service
// @Profile("in")
// @Primary
public class IndianPrimaryGreetingService implements GreetingService {

  @Override
  public String sayGreeting() {
    return "NOMOSHKAR GURU - Primary Indian";
  }

}
