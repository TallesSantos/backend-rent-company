package application.endpoints_soap;


import application.dtos.ClientDTO;
import application.services.ClientService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;

@WebService
@Stateless
public class ClientSoapService {

  @Inject
  private  ClientService clientService;

  @WebMethod
  public List<ClientDTO> listarTodos() {
    return clientService.listarTodos();
  }
}
