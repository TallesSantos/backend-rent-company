package application.endpoints_rest;

import application.dtos.UserDTO;
import application.endpoints_rest.request.AddAddressRequest;
import application.endpoints_rest.request.UserLoginRequest;
import application.endpoints_rest.request.UserSignUpRequest;
import application.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/users")
@Tag(name = "Usuários", description = "Gerenciamento de usuários")
public class UserController {

  @Inject
  private UserService userService;


  @Operation(summary = "Login do usuario")
  @Path("/login")
  @POST
  @Produces({MediaType.APPLICATION_JSON})
  @Consumes({MediaType.APPLICATION_JSON})
  public UserDTO userLogin(UserLoginRequest request) throws Exception {
    return userService.login(request);
  }

  @Operation(summary = "Cadastro do usuario")
  @Path("/sign-up")
  @POST
  @Produces({MediaType.APPLICATION_JSON})
  @Consumes({MediaType.APPLICATION_JSON})
  public UserDTO userSignUp(UserSignUpRequest request) throws Exception {
    return userService.userSignUp(request);
  }

  @Path("/{user-id}/addresses")
  @POST
  @Produces({MediaType.APPLICATION_JSON})
  @Consumes({MediaType.APPLICATION_JSON})
  public void addAddress(@PathParam("user-id") Long userId,  AddAddressRequest request) throws Exception {
     userService.addAddressToUser(userId, request);
  }
}
