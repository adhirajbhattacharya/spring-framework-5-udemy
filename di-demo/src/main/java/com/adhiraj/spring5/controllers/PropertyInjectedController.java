package com.adhiraj.spring5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import com.adhiraj.spring5.service.GreetingService;

@Controller
public class PropertyInjectedController {

  @Autowired
  @Qualifier("propertyGreetingService")
  private GreetingService propertyGreetingService;

  public String hello() {
    return propertyGreetingService.sayGreeting();
  }

}
