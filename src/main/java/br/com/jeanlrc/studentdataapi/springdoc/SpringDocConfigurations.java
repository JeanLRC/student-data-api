package br.com.jeanlrc.studentdataapi.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Student Data API")
                        .description("API Rest da aplicação Student Data API, contendo as funcionalidades de CRUD de Estudantes")
                        .contact(new Contact()
                                .name("Jean Lucas"))
                     );
    }
}
