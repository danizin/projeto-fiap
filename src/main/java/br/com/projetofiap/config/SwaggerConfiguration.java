package br.com.projetofiap.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info().title("Gestão de dispositivos")
                .description("")
                .version("1.0")
                .contact(new Contact().name("FIAP").email("rafael.teixeira@libertyti.com.br,lzguilhermecp@gmail.com").url("https://postech.fiap.com.br/")));
    }
}
