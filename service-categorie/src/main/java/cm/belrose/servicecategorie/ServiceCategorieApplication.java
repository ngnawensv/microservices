package cm.belrose.servicecategorie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceCategorieApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCategorieApplication.class, args);
	}

}
