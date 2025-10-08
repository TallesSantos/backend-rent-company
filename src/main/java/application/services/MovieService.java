package application.services;


import application.converters.MovieConverter;
import application.dtos.MovieDTO;
import application.dtos.request.CreateMovieRequest;
import application.dtos.request.UpdateMovieRequest;
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

  public List<MovieDTO> listAll() {
    return movieRepository.listarTodos().stream()
        .map(MovieConverter::toDto).collect(
        Collectors.toList());
  }

  public void createMovie(CreateMovieRequest request){
      Movie movie = new Movie();
      movie.setName(request.getName());
      movie.setDescription(request.getDescription());
      movie.setRented(false);
      movieRepository.save(movie);
  }

  public void updateMovie(UpdateMovieRequest request) throws Exception {

    if(request.getId() == null){
      throw new Exception("property id cannot be null");
    }

    Movie movie = movieRepository.findById((long)request.getId());

    if(request.getName() != null){
      movie.setName(request.getName());
    }

    if(request.getDescription() != null){
      movie.setDescription(request.getDescription());
    }
    movieRepository.save(movie);

  }

  public void deleteMovie(Long id) throws Exception {
    if(id == null){
      throw new Exception("id cannot be null");
    }
    movieRepository.removeById(id);
  }

}
