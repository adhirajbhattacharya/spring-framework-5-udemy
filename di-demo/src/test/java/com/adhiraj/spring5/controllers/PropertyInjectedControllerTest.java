package com.adhiraj.spring5.controllers;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import com.adhiraj.spring5.service.PropertyGreetingService;

public class PropertyInjectedControllerTest {

  private PropertyInjectedController propertyInjectedController;

  @Before
  public void setUp() {
    propertyInjectedController = new PropertyInjectedController();
    propertyInjectedController.propertyGreetingService = new PropertyGreetingService();
  }

  @Test
  public void testGreeting() {
    assertEquals("HELLO GURU - Inject by property", propertyInjectedController.hello());
  }

}
