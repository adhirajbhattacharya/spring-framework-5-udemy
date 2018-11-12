package com.adhiraj.spring5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import com.adhiraj.spring5.service.GreetingService;

@Controller
public class ConstructorInjectedController {

  private GreetingService greetingService;

  @Autowired // not required as done by spring automatically from spring 4.2
  public ConstructorInjectedController(
      @Qualifier("constructorGreetingService") GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  public String hello() {
    return greetingService.sayGreeting();
  }

}
