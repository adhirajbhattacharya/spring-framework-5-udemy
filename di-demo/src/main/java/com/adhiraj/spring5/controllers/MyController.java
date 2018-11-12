package com.adhiraj.spring5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.adhiraj.spring5.service.GreetingService;

@Controller
public class MyController {

  private GreetingService greetingService;

  @Autowired
  public MyController(GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  public String hello() {
    return greetingService.sayGreeting();
  }

}
