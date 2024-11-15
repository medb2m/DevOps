package tn.foyer.mohamedbenmohamedtpfoyer.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI().info(infoAPI());
    }
    public Info infoAPI() {
        return new Info().title("Mohamed Ben Mohamed")
                .description("TP Foyer")
                .contact(contactAPI());
    }

    public Contact contactAPI() {
        Contact contact = new Contact().name("Equipe ASI II")
                .email("BENMOHAMED.mohamed@esprit.tn ")
                .url("https://www.linkedin.com/in/medb2mm");
        return contact;
    }

    @Bean
    public GroupedOpenApi foyerPublicApi(){
        return GroupedOpenApi.builder()
                .group("ALL APIs")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public GroupedOpenApi blocApi() {
        return GroupedOpenApi.builder()
                .group("Bloc API")
                .pathsToMatch("/BlocRestController/**")
                .build();
    }
    @Bean
    public GroupedOpenApi foyerApi() {
        return GroupedOpenApi.builder()
                .group("Foyer API")
                .pathsToMatch("/FoyerRestController/**")
                .build();
    }

    @Bean
    public GroupedOpenApi universiteApi() {
        return GroupedOpenApi.builder()
                .group("Universite API")
                .pathsToMatch("/UniversiteRestController/**")
                .build();
    }
}
