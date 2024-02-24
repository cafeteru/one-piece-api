package io.github.cafeteru.netflix.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    private static Info getInfo() {
        var email = new Contact().email("cafeteru.dev@gmail.com");
        return new Info()
                .title("Netflix API")
                .description("Api to simulate Netflix services.")
                .version("1.0")
                .contact(email);
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(getInfo());
    }
}
