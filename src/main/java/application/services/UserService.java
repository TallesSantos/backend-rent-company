package application.services;

import application.converters.UserConverter;
import application.dtos.UserDTO;
import application.endpoints_rest.exceptions.SignUpException;
import application.endpoints_rest.request.AddAddressRequest;
import application.endpoints_rest.request.UserLoginRequest;
import application.endpoints_rest.request.UserSignUpRequest;
import application.entities.Address;
import application.entities.Client;
import application.entities.User;
import application.enuns.UserType;
import application.repositories.UserRepository;
import application.repositories.jakarta_automatic_session_management_wild_fly_impl.AddressRepositoryImpl;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.ArrayList;

@Stateless
public class UserService {

  @Inject
  @Named("jakartaRepo")
  private UserRepository userRepository;

  @Inject
  private ClientService clientService;

  @Inject
  private AddressRepositoryImpl addressRepositoryImpl;

  public UserDTO login(UserLoginRequest request) throws Exception {
    User user = userRepository
        .findUserByUsernameAndPassword(request.getUsername(), request.getPassword());

    if (user == null) {
      throw new Exception("User not find");
    }

    return UserConverter.toDto(user);

  }

  public UserDTO userSignUp(UserSignUpRequest request) {

    validateUserSignUpRequest(request);
    User user = new User();

    user.setName(request.getFullName());
    user.setEmail(request.getEmail());
    user.setUsername(request.getUsername());
    user.setPassword(request.getPassword());

    if (request.getDocumentNumber() != null) {
      user.setDocumentNumber(request.getDocumentNumber());
    } else {
      user.setDocumentNumber("No informed");
    }

    if (request.getUserType() != null && request.getUserType().equals("CLIENT")) {
      Client client = new Client();
      client.setName(request.getNickName());
      user.setClient(client);
      user.setUserType(UserType.CLIENT);
    }
    userRepository.save(user);
    return UserConverter.toDto(user);

  }

  public void addAddressToUser(Long userId, AddAddressRequest request) {
    User user = userRepository.findById(userId);

    if (user.getAddresses() == null) {
      user.setAddresses(new ArrayList<>());
    }

    Address newAddress = new Address();
    newAddress.setUser(user);
    newAddress.setCountry(request.getCountry());
    newAddress.setState(request.getState());
    newAddress.setCity(request.getCity());
    newAddress.setStreetAddress(request.getStreetAddress());
    newAddress.setNumber(request.getNumber());
    newAddress.setComment(request.getComment());

    user.getAddresses().add(newAddress);

    addressRepositoryImpl.save(newAddress);
    userRepository.save(user);
  }


  private void validateUserSignUpRequest(UserSignUpRequest request) {
    SignUpException exception = new SignUpException("Error try sign up user");
    if (request.getFullName() == null || request.getFullName().trim().equals("")) {
      exception.addFieldError("name", "name cannot be null");
    }
    if (request.getEmail() == null || request.getEmail().trim().equals("")) {
      exception.addFieldError("email", "email cannot be null");
    }
    if (request.getUsername() == null || request.getUsername().trim().equals("")) {
      exception.addFieldError("username", "username cannot be null");
    }

    if (request.getPassword() == null || request.getPassword().trim().equals("")) {
      exception.addFieldError("password", "password cannot be null");
    }
    if (!exception.getFields().isEmpty()) {
      throw exception;
    }
  }
}
