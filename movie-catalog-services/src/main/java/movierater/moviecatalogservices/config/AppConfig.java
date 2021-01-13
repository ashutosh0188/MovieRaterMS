package movierater.moviecatalogservices.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    @LoadBalanced //This annotation calls eureka server first then get respective service host and port. Then calls that service and get actual response that is expected. And This process is Client side load balancing, which is abstracted inside eureka client.
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
