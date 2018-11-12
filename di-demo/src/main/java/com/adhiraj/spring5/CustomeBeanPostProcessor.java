package com.adhiraj.spring5;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomeBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    if (bean instanceof BeanLifecycleDemo) {
      try {
        ((BeanLifecycleDemo) bean).beforeInit();
      } catch (Exception e) {
      }
      return bean;
    }

    return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    if (bean instanceof BeanLifecycleDemo) {
      try {
        ((BeanLifecycleDemo) bean).afterInit();
      } catch (Exception e) {
      }
      return bean;
    }

    return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
  }

}
