package org.example.configuration;

import clients.RestClient;
import clients.WireMockClient;
import jakarta.annotation.PostConstruct;
import org.example.client.ExternalClient;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import utils.session.SessionImpl;

import static org.mockito.MockitoAnnotations.openMocks;


@Configuration
@PropertySource(value = "classpath:application-test.yml")
//@ComponentScan("ivan.rest.example.test")
@Import({SessionImpl.class, WireMockClient.class, RestClient.class})
public class TestConfig {

  @Spy
  private ExternalClient externalClient;

//  @LocalServerPort private int port;

//  @Value("${employee.service.host}")
//  private String employeeServiceHost;

  @PostConstruct
  void init() {
    openMocks(this);
//    baseUrl = String.format("http://%s:%s", employeeServiceHost, port);
  }

  @Bean
  @Primary
  ExternalClient getExternalClient() {
    return this.externalClient;
  }
}
