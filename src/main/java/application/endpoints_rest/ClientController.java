package application.endpoints_rest;

import application.dtos.RentHistoryDTO;
import application.services.ClientService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/clients")
public class ClientController {

  @Inject
  private ClientService clientService;


  @Path("/{client-id}/rent-history")
  @GET
  @Produces({MediaType.APPLICATION_JSON})
  public List<RentHistoryDTO> listAllRentHistoryOfClient(@PathParam("client-id") Long clientId){
    return  clientService.listRentHistoryByClientId(clientId);
  }

}
