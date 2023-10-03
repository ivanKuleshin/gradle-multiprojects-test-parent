package org.example.configuration;

import org.example.clients.RestClient;
import org.example.clients.WireMockClient;
import jakarta.annotation.PostConstruct;
import org.example.client.ExternalClient;
import org.mockito.Spy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.example.utils.session.SessionImpl;

import static org.mockito.MockitoAnnotations.openMocks;


@Configuration
@PropertySource(value = "classpath:application-test.yml")
@Import({SessionImpl.class, WireMockClient.class, RestClient.class})
public class TestConfig {

  @Spy
  private ExternalClient externalClient;

  @PostConstruct
  void init() {
    openMocks(this);
  }

  @Bean
  @Primary
  ExternalClient getExternalClient() {
    return this.externalClient;
  }
}
