package com.adhiraj.spring5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import com.adhiraj.spring5.service.GreetingService;

@Controller
public class SetterInjectedController {

  private GreetingService greetingService;

  @Autowired
  public void setGreetingService(
      @Qualifier("setterGreetingService") GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  public String hello() {
    return greetingService.sayGreeting();
  }

}
