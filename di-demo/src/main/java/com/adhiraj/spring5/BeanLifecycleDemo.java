package com.adhiraj.spring5;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanLifecycleDemo implements InitializingBean, DisposableBean, BeanNameAware,
    BeanFactoryAware, ApplicationContextAware {

  public BeanLifecycleDemo() {
    System.out.println("***BeanLifecycle - constructor()");
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    System.out.println("***BeanLifecycle - setApplicationContext()");
  }

  @Override
  public void setBeanFactory(BeanFactory arg0) throws BeansException {
    System.out.println("***BeanLifecycle - setBeanFactory()");
  }

  @Override
  public void setBeanName(String arg0) {
    System.out.println("***BeanLifecycle - setBeanName()");
  }

  @Override
  public void destroy() throws Exception {
    System.out.println("***BeanLifecycle - destroy()");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("***BeanLifecycle - afterPropertiesSet()");
  }

  @PostConstruct // indepenpendent annotation
  public void postConstruct() throws Exception {
    System.out.println("***BeanLifecycle - postConstruct()");
  }

  @PreDestroy // indepenpendent annotation
  public void preDestroy() throws Exception {
    System.out.println("***BeanLifecycle - preDestroy()");
  }

  // called by BeanPostProcessor
  public void beforeInit() throws Exception {
    System.out.println("***BeanLifecycle - beforeInit()");
  }

  // called by BeanPostProcessor
  public void afterInit() throws Exception {
    System.out.println("***BeanLifecycle - afterInit()");
  }

}
