package application.services;


import application.converters.ClientConverter;
import application.dtos.ClientDTO;
import application.entities.Client;
import application.entities.Movie;
import application.repositories.ClientRepository;
import application.repositories.MovieRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class ClientService {

  @Inject
  private ClientRepository clientRepository;

  @Inject
  private MovieRepository movieRepository;

  public List<ClientDTO> listAll() {
    return clientRepository.listarTodos().stream()
        .map(ClientConverter::toDto).collect(
            Collectors.toList());
  }

  public void rentMovie(Long clientId, Long movieId) throws Exception {

    Client client = clientRepository.findById(clientId);
    Movie movie = movieRepository.findById(movieId);

    validateRent(client, movie);
    movie.setRented(true);
    movie.setRentedTime(new Date());
    movie.setClient(client);
    client.getMovies().add(movie);

    movieRepository.save(movie);
    clientRepository.save(client);


  }

  public void returnFilm(Long clientId, Long movieId) throws Exception {
    Client client = clientRepository.findById(clientId);
    Movie movie = movieRepository.findById(movieId);

    client.getMovies().remove(movie);
    movie.setClient(null);
    movie.setRentedTime(null);
    movie.setRented(false);

    movieRepository.save(movie);
    clientRepository.save(client);
  }


  private void validateRent(Client client, Movie movie) throws Exception {
    if (movie.getClient() != null) {
      if (movie.getClient().getName().equals(client.getName())) {
        throw new Exception("You alread rent this movie");
      }
      throw new Exception("Movie alread rented");
    }

  }

}
