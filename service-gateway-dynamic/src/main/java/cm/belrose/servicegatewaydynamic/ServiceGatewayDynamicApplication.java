package cm.belrose.servicegatewaydynamic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableEurekaClient
public class ServiceGatewayDynamicApplication {

	/**
	 * Avec cette configuration on attaque un service en faisant: localhost:port://NOM_SERVICE/ressource
	 * Exemple: localhost:8888://SERVICE-CATEGORIE/categories
	 * @param rdc
	 * @param dlp
	 * @return
	 */
	@Bean
	public DiscoveryClientRouteDefinitionLocator discoveryClientRouteDefinitionLocator(ReactiveDiscoveryClient rdc,
																					   DiscoveryLocatorProperties dlp){
		return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceGatewayDynamicApplication.class, args);
	}

}
