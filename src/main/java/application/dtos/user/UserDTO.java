package application.dtos.user;

import java.util.List;


public class UserDTO {

  private Long id;

  private String name;

  private String email;

  private String userType;

  private List<AddressDTO> addresses;


  private List<PhoneDTO> phone;

  private List<PermissionDTO> permissionRoles;

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

  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
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
}
