package application.endpoints_soap;


import application.dtos.ClientDTO;
import application.services.ClientService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.util.List;

@WebService
@Stateless
public class ClientSoapService {

  @Inject
  private  ClientService clientService;

  @WebMethod
  public List<ClientDTO> listAll() {
    System.out.println("bateu na listagem de clientes");
    return clientService.listAll();
  }

  @WebMethod
  public void rentMovie(@WebParam Long clientId, @WebParam Long movieId) throws Exception {
     clientService.rentMovie(clientId, movieId);
  }

  @WebMethod
  public void returnMovie(@WebParam Long clientId, @WebParam Long movieId) throws Exception {
    clientService.returnFilm(clientId, movieId);
  }



}
