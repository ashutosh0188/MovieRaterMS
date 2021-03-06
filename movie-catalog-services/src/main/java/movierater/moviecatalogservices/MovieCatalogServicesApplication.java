package movierater.moviecatalogservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableEurekaClient //This is optional. After adding eureka client dependency. This SpringBootApplication should behave as eureka client by default.
@EnableCircuitBreaker
@EnableHystrixDashboard
public class MovieCatalogServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServicesApplication.class, args);
	}

}
