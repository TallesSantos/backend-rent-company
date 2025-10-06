package application.services;


import application.entities.Client;
import application.entities.Movie;
import application.repositories.ClientRepository;
import application.repositories.MovieRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class ClientService {

  @Inject
  private ClientRepository clientRepository;

  public List<Client> listarTodos() {
    return clientRepository.listarTodos();
  }

}
