package com.adhiraj.spring5.controllers;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import com.adhiraj.spring5.service.SetterGreetingService;

public class SetterInjectedControllerTest {

  private SetterInjectedController setterInjectedController;

  @Before
  public void setUp() {
    setterInjectedController = new SetterInjectedController();
    setterInjectedController.setGreetingService(new SetterGreetingService());
  }

  @Test
  public void testGreeting() {
    assertEquals("HELLO GURU - Inject by setter", setterInjectedController.hello());
  }

}
