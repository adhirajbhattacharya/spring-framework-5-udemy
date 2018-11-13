package com.adhiraj.spring5.controllers;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import com.adhiraj.spring5.service.ConstructorGreetingService;

public class ConstructorInjectedControllerTest {

  private ConstructorInjectedController constructorInjectedController;

  @Before
  public void setUp() {
    constructorInjectedController =
        new ConstructorInjectedController(new ConstructorGreetingService());
  }

  @Test
  public void testGreeting() {
    assertEquals("HELLO GURU - Inject by constructor", constructorInjectedController.hello());
  }

}
