package application.services;


import application.converters.ClientConverter;
import application.dtos.ClientDTO;
import application.dtos.RentHistoryDTO;
import application.entities.Client;
import application.entities.Movie;
import application.repositories.jakarta_automatic_session_management_wild_fly_impl.ClientRepositoryImpl;
import application.repositories.jakarta_automatic_session_management_wild_fly_impl.MovieRepositoryImpl;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class ClientService {

  @Inject
  private ClientRepositoryImpl clientRepositoryImpl;

  @Inject
  private MovieRepositoryImpl movieRepositoryImpl;

  public List<ClientDTO> listAll() {
    return clientRepositoryImpl.listAll().stream()
        .map(ClientConverter::toDto).collect(
            Collectors.toList());
  }

  public Client findById(Long id){
    return clientRepositoryImpl.findById(id);
  }

  public void rentMovie(Long clientId, Long movieId) throws Exception {

    Client client = clientRepositoryImpl.findById(clientId);
    Movie movie = movieRepositoryImpl.findById(movieId);

    validateRent(client, movie);
    movie.setRented(true);
    movie.setRentedTime(new Date());
    movie.setClient(client);
    client.getMovies().add(movie);

    movieRepositoryImpl.save(movie);
    clientRepositoryImpl.save(client);


  }

  public void returnFilm(Long clientId, Long movieId) throws Exception {
    Client client = clientRepositoryImpl.findById(clientId);
    Movie movie = movieRepositoryImpl.findById(movieId);

    client.getMovies().remove(movie);
    movie.setClient(null);
    movie.setRentedTime(null);
    movie.setRented(false);

    movieRepositoryImpl.save(movie);
    clientRepositoryImpl.save(client);
  }

  public List<RentHistoryDTO> listRentHistoryByClientId(Long clientId) {
    if (clientId == null) {
      throw new RuntimeException("ClientId can't be null");
    }
    Client client = clientRepositoryImpl.findById(clientId);
  return null;
  }



  private void validateRent(Client client, Movie movie) throws Exception {
    if (movie.getClient() != null) {
      if (movie.getClient().getName().equals(client.getName())) {
        throw new Exception("You alread rent this movie");
      }
      throw new Exception("Movie alread rented");
    }

  }


  public void save(Client client) {
    clientRepositoryImpl.save(client);
  }
}
