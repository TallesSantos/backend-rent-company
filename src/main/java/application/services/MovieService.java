package application.services;


import application.converters.MovieConverter;
import application.dtos.MovieDTO;
import application.entities.Movie;
import application.repositories.MovieRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class MovieService {

  @Inject
  private MovieRepository movieRepository;

  public List<MovieDTO> listarTodos() {
    return movieRepository.listarTodos().stream()
        .map(MovieConverter::toDto).collect(
        Collectors.toList());
  }

}
