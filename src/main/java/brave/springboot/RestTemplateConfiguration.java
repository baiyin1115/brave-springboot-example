package brave.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/** The application is simple, it only uses Web MVC and a {@linkplain RestTemplate}. */

@Configuration
public class RestTemplateConfiguration {
  @Bean RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
