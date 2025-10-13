package application.endpoints_rest;

import application.dtos.UserDTO;
import application.endpoints_rest.request.UserLoginRequest;
import application.services.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/users")
public class UserController {

  @Inject
  private UserService userService;


  @Path("/login")
  @POST
  @Produces({MediaType.APPLICATION_JSON})
  @Consumes({MediaType.APPLICATION_JSON})
  public UserDTO userLogin(UserLoginRequest request) throws Exception {
    return userService.login(request);
  }

}
