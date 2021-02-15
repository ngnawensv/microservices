package cm.belrose.servicearticle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
//@EnableFeignClients  demande à Feign de scanner le package "cm.belrose"  pour rechercher des classes qui se déclarent clients Feign.
@EnableFeignClients ("cm.belrose")
public class ServiceArticleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceArticleApplication.class, args);
	}

}
