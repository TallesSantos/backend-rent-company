package application.entities;

import application.enuns.UserType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;


@Entity
@Table(name = "`user`")
public class User {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String email;

  @Column(name = "user_type")
  @Enumerated(EnumType.STRING)
  private UserType userType;

  @OneToOne()
  @JoinColumn(name="client_id")
  private Client client;

  private String username;

  private String password;

  @OneToMany
  @JoinColumn(name = "user_id")
  private List<Address> addresses;


  @OneToMany
  @JoinColumn(name = "user_id")
  private List<Phone> phone;


  @ManyToMany
  @JoinTable(
      name = "user_permission", // Nome da tabela de junção
      joinColumns = @JoinColumn(name = "user_id"), // FK para a tabela User
      inverseJoinColumns = @JoinColumn(name = "permission_id") // FK para Permission
  )
  private List<Permission> permissionRoles;

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

  public List<Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
  }

  public List<Permission> getPermissionRoles() {
    return permissionRoles;
  }

  public void setPermissionRoles(List<Permission> permissionRoles) {
    this.permissionRoles = permissionRoles;
  }

  public List<Phone> getPhone() {
    return phone;
  }

  public void setPhone(List<Phone> phone) {
    this.phone = phone;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserType getUserType() {
    return userType;
  }

  public void setUserType(UserType userType) {
    this.userType = userType;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }
}
