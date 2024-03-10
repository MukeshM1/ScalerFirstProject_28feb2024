package dev.mukeshm1.scalerfirstproject_28feb2024.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }
}
