package cm.belrose.servicegatewaystaticclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class ServiceGatewayStaticClassApplication {

    /**
     * Configuration statique des routes avec spécification de l'adresse Ip, et le nom de domain ou se trouve le service
     * dans l'uri
     * @param builder
     * @return
     */

  /*  @Bean
    public RouteLocator routes(RouteLocatorBuilder builder){
        return builder.routes()
                .route("r1",
                        r->r.path("/categories/**").uri("http://localhost:8081"))
                .route("r2",
                        r->r.path("/articles/**").uri("http://localhost:8082"))
                .build();
    }*/

    /**
     * Configuration statique des routes avec specification du nom du microservice dans l'uri et l'utilisation
     * du loard balanced(lb) pour la repartition des charges en cas de demarrage de plusieurs instances d'un microservice
     * @param builder
     * @return
     */
	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder){
	return builder.routes()
			.route("r1",
					r->r.path("/categories/**").uri("lb://SERVICE-CATEGORIE"))
			.route("r2",
					r->r.path("/articles/**").uri("lb://SERVICE-ARTICLE"))
			.build();
}

	public static void main(String[] args) {
		SpringApplication.run(ServiceGatewayStaticClassApplication.class, args);
	}

}
