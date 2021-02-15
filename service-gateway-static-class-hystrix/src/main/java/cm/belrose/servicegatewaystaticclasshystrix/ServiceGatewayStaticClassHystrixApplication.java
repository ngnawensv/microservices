package cm.belrose.servicegatewaystaticclasshystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableHystrix
public class ServiceGatewayStaticClassHystrixApplication {

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder){
		return builder.routes()
				.route("r1",
						r->r.path("/categories/**")
								.filters(f -> f.hystrix(h -> h.setName("Hystrix")
										.setFallbackUri("forward:/fallback/message")))
								.uri("lb://SERVICE-CATEGORIE"))
				.route("r2",
						r->r.path("/articles/**").uri("lb://SERVICE-ARTICLE"))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceGatewayStaticClassHystrixApplication.class, args);
	}

}
