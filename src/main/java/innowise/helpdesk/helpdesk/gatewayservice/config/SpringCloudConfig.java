package innowise.helpdesk.helpdesk.gatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder
                .routes()

                .route("historys_route",
                        route -> route.path("/api/historys/**")
                                .uri("lb://history-service"))
                .route("keycloak_route",
                        route->route.path("/api/keycloak/**")
                                .uri("lb://helpdesk-security-keycloak"))

                .build();
    }

}
