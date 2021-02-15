package cm.belrose.servicecategorie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ServiceCategorieApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCategorieApplication.class, args);
	}

}
