package application.controllers;

import application.entities.Client;
import application.entities.Movie;
import application.services.ClientService;
import application.services.MovieService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/clients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientController {

  @Inject
  private ClientService clientService;

  @GET
  public List<Client> listar() {
    return clientService.listarTodos();
  }


}
