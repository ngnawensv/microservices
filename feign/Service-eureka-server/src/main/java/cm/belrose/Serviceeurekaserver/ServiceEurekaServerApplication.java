package cm.belrose.Serviceeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @EnableEurekaServer permet d'activer le service d'enregistrement
 */
@SpringBootApplication
@EnableEurekaServer
public class ServiceEurekaServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceEurekaServerApplication.class, args);
	}

}
