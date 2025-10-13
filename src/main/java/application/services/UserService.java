package application.services;

import application.converters.UserConverter;
import application.dtos.UserDTO;
import application.endpoints_rest.request.UserLoginRequest;
import application.entities.User;
import application.repositories.UserRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class UserService {

  @Inject
  private UserRepository userRepository;

  public UserDTO login(UserLoginRequest request) throws Exception {
    User user = userRepository
        .findUserByUsernameAndPassword(request.getUsername(), request.getPassword());

    if(user== null){
      throw new Exception("User not find");
    }

    return  UserConverter.toDto(user);

  }
}
