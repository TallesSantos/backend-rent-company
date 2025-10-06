package application.controllers;

import application.entities.Movie;
import application.services.MovieService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/movies")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class MovieController {

  @Inject
  private MovieService movieService;

  @GET
  public List<Movie> listar() {
    return movieService.listarTodos();
  }

}
