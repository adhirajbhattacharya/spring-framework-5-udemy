package com.adhiraj.spring5.service;

public class GreetingServiceFactory {

  public GreetingService createGreetingService(String lang) {
    switch (lang) {
      case "in":
        return new IndianPrimaryGreetingService();
      case "es":
        return new SpanishPrimaryGreetingService();
      // case "en":
      default:
        return new PrimaryGreetingService();
    }
  }

}
