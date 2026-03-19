package com.example.demo.config;

import com.example.demo.config.properties.OpenApiProperties;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenApiConfig
 */
@Configuration
@RequiredArgsConstructor
public class OpenApiConfig {

  private final OpenApiProperties openApiProperties;

  @Bean
  public OpenAPI customOpenAPI() {
    final String securitySchemeName = "Bearer";
    return new OpenAPI()
      .info(getApiInfo())
      .addSecurityItem(new SecurityRequirement()
        .addList(securitySchemeName))
      .components(new Components()
        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
          .name(securitySchemeName)
          .type(SecurityScheme.Type.HTTP)
          .in(SecurityScheme.In.HEADER)
          .scheme("bearer")
          .bearerFormat("JWT")));
  }

  private Info getApiInfo() {
    OpenApiProperties.Project project = openApiProperties.getProject();
    return new Info()
      .title(project.getName())
      .description(project.getDescription())
      .version(project.getVersion())
      .contact(new io.swagger.v3.oas.models.info.Contact()
        .name(project.getContactName())
        .email(project.getContactEmail()));
  }

}
