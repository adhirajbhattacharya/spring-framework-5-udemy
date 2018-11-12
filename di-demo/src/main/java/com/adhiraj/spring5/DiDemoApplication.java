package com.adhiraj.spring5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import com.adhiraj.spring5.controllers.ConstructorInjectedController;
import com.adhiraj.spring5.controllers.MyController;
import com.adhiraj.spring5.controllers.PropertyInjectedController;
import com.adhiraj.spring5.controllers.SetterInjectedController;

@SpringBootApplication
@ComponentScan(basePackages = {"com.adhiraj.spring5"})
// base package by default is the @SpringBootApplication class
// @ComponentScan overrides default behavior completely
public class DiDemoApplication {

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

    MyController controller = (MyController) ctx.getBean("myController");
    System.out.println(controller.hello());

    System.out.println(ctx.getBean(PropertyInjectedController.class).hello());
    System.out.println(ctx.getBean(SetterInjectedController.class).hello());
    System.out.println(ctx.getBean(ConstructorInjectedController.class).hello());
  }
}
