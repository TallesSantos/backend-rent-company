package application;

import application.endpoints_rest.UserController;
import application.swagger.SwaggerUIResource;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@OpenAPIDefinition(
    info = @Info(
        title = "API de Exemplo",
        version = "1.0",
        description = "Documentação gerada automaticamente com Swagger"
    ),
    servers = {
        @Server(url = "http://localhost:8080/api-curse/api")
    }
)
@ApplicationPath("/api")
public class RestApplication extends Application {
  // Pode ficar vazio, só ativa o JAX-RS no caminho /api

  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> resources = new HashSet<>();

    // Registra suas APIs
    resources.add(UserController.class);

    // Registra o recurso do Swagger (gera o openapi.json)
    resources.add(OpenApiResource.class);

    // (Opcional) registra Swagger UI se você tiver a classe
    resources.add(SwaggerUIResource.class);

    return resources;
  }

}