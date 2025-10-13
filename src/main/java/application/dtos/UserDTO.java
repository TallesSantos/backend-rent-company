package application.dtos;

import application.dtos.user.AddressDTO;
import application.dtos.user.PermissionDTO;
import application.dtos.user.PhoneDTO;
import java.util.List;

public class UserDTO {


  private Long id;

  private String name;

  private String email;

  private String userType;

  private List<AddressDTO> addresses;

  private List<PhoneDTO> phone;

  private List<PermissionDTO> permissionRoles;

  private ClientDTO client;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<AddressDTO> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<AddressDTO> addresses) {
    this.addresses = addresses;
  }

  public List<PhoneDTO> getPhone() {
    return phone;
  }

  public void setPhone(List<PhoneDTO> phone) {
    this.phone = phone;
  }

  public List<PermissionDTO> getPermissionRoles() {
    return permissionRoles;
  }

  public void setPermissionRoles(List<PermissionDTO> permissionRoles) {
    this.permissionRoles = permissionRoles;
  }

  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }

  public ClientDTO getClient() {
    return client;
  }

  public void setClient(ClientDTO client) {
    this.client = client;
  }
}
