package br.com.senac.ecommerce.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Comida Japonesa")
                        .description("API REST Java 21 com Spring Boot, MySQL e CRUD com exclusão lógica quando a tabela possui campo de status numérico.")
                        .version("1.0.0")
                        .contact(new Contact().name("Senac")));
    }
}
