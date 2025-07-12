package br.com.forumhub.infra.security.springDoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        final String securitySchemeName = "bearer-key";

        return new OpenAPI()
                .info(new Info().title("ForumHub API").version("1.0"))
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName)) // ✅ Aplica globalmente
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName,
                                new SecurityScheme()
                                        .name(securitySchemeName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")));
    }
}
