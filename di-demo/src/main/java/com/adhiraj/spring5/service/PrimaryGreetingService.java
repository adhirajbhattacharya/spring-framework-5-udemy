package com.adhiraj.spring5.service;

//@Service
//@Profile({"en", "default"}) // default is present when no other is mentioned
//@Primary
//moved to @Configuration file

public class PrimaryGreetingService implements GreetingService {

  @Override
  public String sayGreeting() {
    return "HELLO GURU - Primary";
  }

}
