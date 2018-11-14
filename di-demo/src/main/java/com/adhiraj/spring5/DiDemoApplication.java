package com.adhiraj.spring5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import com.adhiraj.spring5.controllers.ConstructorInjectedController;
import com.adhiraj.spring5.controllers.MyController;
import com.adhiraj.spring5.controllers.PropertyInjectedController;
import com.adhiraj.spring5.controllers.SetterInjectedController;
import com.adhiraj.spring5.fake.datasource.FakeDatasource;
import com.adhiraj.spring5.fake.datasource.FakeJmsBroker;
import com.adhiraj.spring5.service.GreetingService;

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
    for (String bean : ctx.getBeanNamesForType(GreetingService.class))
      System.out.println(bean);

    FakeDatasource datasource = ctx.getBean(FakeDatasource.class);
    System.out.println("Datasource URL      :" + datasource.getUrl());
    System.out.println("Datasource Username :" + datasource.getUsername());
    System.out.println("Datasource Password :" + datasource.getPassword());
    
    FakeJmsBroker jmsBroker = ctx.getBean(FakeJmsBroker.class);
    System.out.println("JmsBroker URL      :" + jmsBroker.getUrl());
    System.out.println("JmsBroker Username :" + jmsBroker.getUsername());
    System.out.println("JmsBroker Password :" + jmsBroker.getPassword());
  }
}
