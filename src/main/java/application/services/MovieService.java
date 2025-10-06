package application.services;


import application.entities.Movie;
import application.repositories.MovieRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class MovieService {

  @Inject
  private MovieRepository movieRepository;

  public List<Movie> listarTodos() {
    return movieRepository.listarTodos();
  }

}
