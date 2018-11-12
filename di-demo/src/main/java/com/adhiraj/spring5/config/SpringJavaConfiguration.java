package com.adhiraj.spring5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import com.adhiraj.spring5.service.GreetingService;
import com.adhiraj.spring5.service.GreetingServiceFactory;

@Configuration
public class SpringJavaConfiguration {

  @Bean
  public GreetingServiceFactory greetingServiceFactory() {
    return new GreetingServiceFactory();
  }

  @Bean
  @Primary
  @Profile({"en", "default"})
  public GreetingService primaryGreetingService() {
    return greetingServiceFactory().createGreetingService("en");
  }

  @Bean
  @Primary
  @Profile("in")
  public GreetingService indianPrimaryGreetingService() {
    return greetingServiceFactory().createGreetingService("in");
  }

  @Bean
  @Primary
  @Profile("es")
  public GreetingService spanishPrimaryGreetingService() {
    return greetingServiceFactory().createGreetingService("es");
  }
}
