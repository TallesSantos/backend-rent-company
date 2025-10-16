package application.swagger;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/swagger")
public class SwaggerUIResource {

  @GET
  @Path("/")
  public Response redirectToUI() {
    return Response
        .seeOther(java.net.URI.create("/webjars/swagger-ui/5.10.3/index.html?url=/api/openapi.json"))
        .build();
  }
}