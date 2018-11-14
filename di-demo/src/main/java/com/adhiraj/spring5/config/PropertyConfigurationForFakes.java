package com.adhiraj.spring5.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import com.adhiraj.spring5.fake.datasource.FakeDatasource;
import com.adhiraj.spring5.fake.datasource.FakeJmsBroker;

@Configuration
// @PropertySource({"classpath:datasource.properties","classpath:jms.properties"})
public class PropertyConfigurationForFakes {

  private Environment env;

  @SuppressWarnings("unused")
  private String user;

  private String password;

  private String url;

  private String jmsUser;

  private String jmsPassword;

  private String jmsUrl;

  @Autowired
  public PropertyConfigurationForFakes(Environment env,
      @Value("${adhiraj.db.username}") String user,
      @Value("${adhiraj.db.password}") String password, @Value("${adhiraj.db.url}") String url,
      @Value("${adhiraj.jms.username}") String jmsUser,
      @Value("${adhiraj.jms.password}") String jmsPassword,
      @Value("${adhiraj.jms.url}") String jmsUrl) {
    super();
    this.env = env;
    this.user = user;
    this.password = password;
    this.url = url;
    this.jmsUser = jmsUser;
    this.jmsPassword = jmsPassword;
    this.jmsUrl = jmsUrl;
  }

  @Bean
  public FakeDatasource fakeDatasource() {
    FakeDatasource datasource = new FakeDatasource();
    datasource.setUrl(url);
    datasource.setPassword(password);
    datasource.setUsername(env.getProperty("username"));
    return datasource;
  }

  @Bean
  public FakeJmsBroker fakeJmsBroker() {
    FakeJmsBroker jmsBroker = new FakeJmsBroker();
    jmsBroker.setUrl(jmsUser);
    jmsBroker.setPassword(jmsPassword);
    jmsBroker.setUsername(jmsUrl);
    return jmsBroker;
  }

  @Bean
  public static PropertySourcesPlaceholderConfigurer properties() {
    return new PropertySourcesPlaceholderConfigurer();
  }

}
