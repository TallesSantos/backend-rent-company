package application.services;


import application.converters.ClientConverter;
import application.dtos.ClientDTO;
import application.entities.Client;
import application.entities.Movie;
import application.repositories.ClientRepository;
import application.repositories.MovieRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class ClientService {

  @Inject
  private ClientRepository clientRepository;

  public List<ClientDTO> listarTodos() {
    return clientRepository.listarTodos().stream()
        .map(ClientConverter::toDto).collect(
        Collectors.toList());
  }

}
